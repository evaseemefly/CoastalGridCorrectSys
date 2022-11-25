# + 22-08-07
# 作业 py
# 不同的作业任务
from abc import ABCMeta, abstractmethod
import datetime
import pathlib
import arrow
from typing import List
from util.enum import IssureEnum, ForecastTypeEnum, ProductTypeEunm, ForecastAreaEnum, ForecastElementEnum, \
    RevisalTypeEnum, LevelEnum
from model.models import BaseFileInfoModel
from db.db import DbFactory
from cache.connect import get_cache_conn, get_lpop


class FileBase:
    """
        文件父类，根据文件全名称提取对应的属性
        file eg: 发布单位_预报类型_产品类型_预报总区域_发布时间（YYYYMMDDhhmm）_ 预报最大时效预报间隔时次_预报要素_订正方法_数据级别.nc
                 NMF_BEN_OSM_CSDT_202207282000_120003_SSW_00_L0.nc
                 issurer_ forecast_type_ product_type_ forecast_area_ YYYYMMDDhhmm_ xx_ forecast_element_ revisal_type_ level_
        path eg: /MarineFCST/NMF/china_seas/whole/NMF_BEN_DT_CS_grid/
    """

    def __init__(self, full_path: str, update_dt: datetime.datetime, **kwargs):
        """

        @param full_path:
        @param kwargs:
        """
        self.full_path = full_path
        self.update_dt = update_dt
        self.event_type: str = kwargs.get('event_type')
        self._path: pathlib = pathlib.Path(full_path)

    @property
    def dir_path(self) -> str:
        return str(self._path.parent)

    @property
    def file_full_name(self) -> str:
        """
            获取文件全名称(含后缀)
        @return:
        """
        return self._path.name

    @property
    def file_name(self) -> str:
        """
            获取文件名称(不含后缀)
        @return:
        """
        return self._path.stem

    @property
    def file_size(self) -> int:
        """
            + 22-08-16 获取指定路径的文件的大小
        """
        size = pathlib.Path(self.full_path).stat().st_size if pathlib.Path(self.full_path).is_file() else 0,
        return size

    @property
    def file_ext(self) -> str:
        return self._path.suffix

    @property
    def file_name_splice(self) -> List[str]:
        return self.file_name.split('_')

    @property
    def stamp_issurer(self) -> IssureEnum:
        """
            获取机构
        @return:
        """
        val = self.file_name_splice[0]
        dicts = {
            'NMF': IssureEnum.NMF,
            'PZJ': IssureEnum.PZJ,
            'REF': IssureEnum.REF,
            'RNF': IssureEnum.RNF,
            'PLN': IssureEnum.PLN
        }
        return dicts.get(val, None)

    @property
    def stamp_forecast_type(self) -> ForecastTypeEnum:
        """
            预报类型
        @return:
        """
        val = self.file_name_splice[1]
        dicts = {
            'BEN': ForecastTypeEnum.BEN
        }
        return dicts.get(val, None)

    @property
    def stamp_product_type(self) -> ProductTypeEunm:
        """
            产品类型
        @return:
        """
        val = self.file_name_splice[2]
        dicts = {
            'OSM': ProductTypeEunm.OSM
        }
        return dicts.get(val, None)

    @property
    def stamp_forecast_area(self) -> ForecastAreaEnum:
        """
            预报区域
        @return:
        """
        val = self.file_name_splice[3]
        dicts = {
            'CSDT': ForecastAreaEnum.CSDT,
            'ZJS': ForecastAreaEnum.ZJS,
            'DHDT': ForecastAreaEnum.DHDT,
            'LNS': ForecastAreaEnum.LNS,
            'BHDT': ForecastAreaEnum.BHDT
        }
        return dicts.get(val, None)

    @property
    def stamp_period_interval(self) -> str:
        """
            预报最大时效+预报时间间隔 stamp str
        @return:
        """
        val = self.file_name_splice[5]
        return val

    @property
    def stamp_period(self) -> int:
        """
            获取预报最大时效
        @return:
        """
        return int(self.stamp_period_interval[:3])

    @property
    def stamp_interval(self) -> int:
        """
            获取预报时间间隔
        @return:
        """
        return int(self.stamp_period_interval[3:])

    @property
    def stamp_forecast_dt(self) -> arrow:
        """
            预报时间(发布时间)
        @return:
        """
        val = self.file_name_splice[4]
        forecast_dt_str: str = val
        # TODO:[-] 22-08-16 注意此处直接从文件名读取的事件为 local 时间需要 -> utc
        forecast_dt_local: arrow = arrow.get(forecast_dt_str, 'YYYYMMDDhhmm')
        forecast_dt_utc: arrow = forecast_dt_local.shift(hours=-8)
        return forecast_dt_utc

    @property
    def stamp_forecast_element(self) -> ForecastElementEnum:
        """
            预报要素
        @return:
        """
        val = self.file_name_splice[6]
        dicts = {
            'SSW': ForecastElementEnum.SSW,
            'WAV': ForecastElementEnum.WAV,
            'OCU': ForecastElementEnum.OCU,
            'SST': ForecastElementEnum.SST
        }
        return dicts.get(val, ForecastElementEnum.NULL)

    @property
    def stamp_revisal_type(self) -> RevisalTypeEnum:
        """
            订正方法
        @return:
        """
        val = self.file_name_splice[7]
        dicts = {
            '00': RevisalTypeEnum.UN,
            '10': RevisalTypeEnum.MANUAL,
            '20': RevisalTypeEnum.OBJECTIVE,

        }
        return dicts.get(val, RevisalTypeEnum.UN)

    @property
    def stamp_level(self) -> LevelEnum:
        """
            数据级别
        @return:
        """
        val = self.file_name_splice[8]
        dicts = {
            'L0': LevelEnum.L0,
            'L1': LevelEnum.L1,
            'L2': LevelEnum.L2,
            'L3': LevelEnum.L3,
            'L4': LevelEnum.L4,
            'L5': LevelEnum.L5,

        }
        return dicts.get(val, LevelEnum.L99)


class ITask(metaclass=ABCMeta):

    def __init__(self, file: FileBase, **kwargs):
        self.full_path = full_path
        self.dt = dt
        pass

    """
        任务抽象类
    """

    @abstractmethod
    def to_do(self, *args, **kwargs):
        """
            每个任务实现类需要重写的执行任务方法
        @param args:
        @param kwargs:
        @return:
        """
        pass

    # @property
    # def dir_path(self) -> str:
    #     """
    #         获取存储路径
    #     @return:
    #     """
    #     pass
    #
    # @property
    # def file_name(self) -> str:
    #     """
    #         获取文件名称
    #     @return:
    #     """
    #     pass
    #
    # @property
    # def file_ext(self) -> str:
    #     """
    #         获取文件后缀
    #     @return:
    #     """
    #     pass


class WatchFileTask(ITask):
    def __init__(self, **kwargs):
        self.file: FileBase = None
        self.session = DbFactory().Session

    def to_do(self, *args, **kwargs):
        """
            对于监听文件进行标准化处理
            1- 定时从 redis 中取出数组(指定长度)
            2- 执行 to_store 操作
        @param args:
        @param kwargs:
        @return:
        """
        quene_count: int = kwargs.get('quene_count', 1)
        # self.get_catche_list()
        for index in range(quene_count):
            watch_file = self.get_cache_file()
            if watch_file is not None:
                # {
                # 'full_path': 'D:\\05data\\05three_level_grid\\NMF_BEN_OSM_CSDT_202208110800_120003_SSW_00_L0.nc',
                # 'gmt_created': 1660156336.054919,
                # 'event_type': 'modified'
                # }
                file_full_path: str = watch_file.get('full_path')
                file_create_ts: float = float(watch_file.get('gmt_created'))
                file_event_type_str: str = watch_file.get('event_type')
                file_create_dt_utc: datetime.datetime = arrow.get(file_create_ts).datetime
                msg = ''
                try:
                    file_info = FileBase(file_full_path, file_create_dt_utc, event_type=file_event_type_str)
                    if file_info is not None:
                        msg = f'now:{datetime.datetime.now()},当前处理文件:{file_info.file_name}'
                        self.to_store(file_info)
                    else:
                        msg = f'now:{datetime.datetime.now()},当前无需处理文件'
                except Exception as e:
                    msg = f'处理{file_full_path}时出错,错误代码:{e.args}'
                print(msg)
        pass

    def get_cache_file(self) -> dict:
        """
            获取缓存中的 left top 监听文件
        @return: 有可能为None
        """
        pop_obj = get_lpop()
        # print(pop_obj)
        return pop_obj

    def get_catche_list(self, count: int):
        """
            从缓存中获取指定集合
            TODO:[-] 22-08-10 此处存在的问题:每次执行时通过设置每次读取的长度，分批处理，还需要加入获取 list 长度再根据 count 进行分批读取
        @param count: 从集合中读取的长度
        @return:
        """
        # {'full_path': 'D:\\05data\\05three_level_grid\\NMF_BEN_OSM_CSDT_202208110800_120003_SSW_00_L0.nc',
        # 'gmt_created': 1660156336.054919,
        # 'event_type': 'modified'}

        pass

    def to_store(self, file: FileBase, **kwargs):
        """
            step1: file -> model
            step2: 进行 to_stand -> bool -> model.is_standard
            step3: 缺少一个获取 nc 中变量的步骤以及对应db中的field
        @param kwargs:
        @return:
        """

        file_model = BaseFileInfoModel(issurer_id=file.stamp_issurer.value,
                                       forecast_time=file.stamp_forecast_dt.datetime,
                                       update_time=file.update_dt,
                                       product_type=file.stamp_product_type.value,
                                       forecast_area=file.stamp_forecast_area.value,
                                       forecast_type=file.stamp_forecast_type.value,
                                       forecast_period=file.stamp_period,
                                       forecast_interval=file.stamp_interval,
                                       forecast_element=file.stamp_forecast_element.value,
                                       level=file.stamp_level.value,
                                       revisal_type=file.stamp_revisal_type.value,
                                       file_name=file.file_name,
                                       file_ext=file.file_ext,
                                       file_full_name=file.file_full_name,
                                       size=file.file_size,
                                       path=file.dir_path,
                                       is_standard=self.check_is_stand(),
                                       event_type=file.event_type
                                       )
        self.session.add(file_model)
        self.session.commit()
        pass

    def check_is_stand(self, **kwargs) -> bool:
        return False

# class FileWatchFactory:
#     def __init__(self):
#         pass
#
#     def run(self, full_path: str, gmt_created: datetime.datetime):
#         """
#             根据当前获取的文件全路径执行后续工作流程
#         @param full_path:
#         @param gmt_created:
#         @return:
#         """
#
#         fileInfo = FileBase(full_path, gmt_created=gmt_created)
#         task: ITask = WatchFileTask(fileInfo)
#         task.to_do()
