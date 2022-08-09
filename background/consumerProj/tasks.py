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
        self._path: pathlib = pathlib(full_path)

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
            'CSDT': ForecastAreaEnum.CSDT
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
        forecast_dt: arrow = arrow.get(forecast_dt_str, 'YYYYMMDDhhmm')
        return forecast_dt

    @property
    def stamp_forecast_element(self) -> ForecastElementEnum:
        """
            预报要素
        @return:
        """
        val = self.file_name_splice[6]
        dicts = {
            'SSW': ForecastElementEnum.SSW
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
    def __init__(self, file: FileBase, **kwargs):
        self.file = file
        self.session = DbFactory().Session

    def to_do(self, *args, **kwargs):
        """
            对于监听文件进行标准化处理
        @param args:
        @param kwargs:
        @return:
        """

        pass

    def to_store(self, **kwargs):
        """
            step1: file -> model
            step2: 进行 to_stand -> bool -> model.is_standard
            step3: 缺少一个获取 nc 中变量的步骤以及对应db中的field
        @param kwargs:
        @return:
        """

        file_model = BaseFileInfoModel(issurer_id=self.file.stamp_issurer.value,
                                       forecast_time=self.file.stamp_forecast_dt,
                                       update_time=self.file.update_dt,
                                       product_type=self.file.stamp_product_type.value,
                                       forecast_area=self.file.stamp_forecast_area.value,
                                       forecast_type=self.file.stamp_forecast_type.value,
                                       forecast_period=self.file.stamp_period,
                                       forecast_interval=self.file.stamp_interval,
                                       forecast_element=self.file.stamp_forecast_element.value,
                                       file_name=self.file.file_name,
                                       file_ext=self.file.file_ext,
                                       file_full_name=self.file.file_full_name,
                                       path=self.file.dir_path,
                                       is_standard=self.check_is_stand()
                                       )
        self.session.add(file_model)
        self.session.commit()
        pass

    def check_is_stand(self, **kwargs) -> bool:
        return False


class FileWatchFactory:
    def __init__(self):
        pass

    def run(self, full_path: str, gmt_created: datetime.datetime):
        """
            根据当前获取的文件全路径执行后续工作流程
        @param full_path:
        @param gmt_created:
        @return:
        """

        fileInfo = FileBase(full_path, gmt_created=gmt_created)
        task: ITask = WatchFileTask(fileInfo)
        task.to_do()
