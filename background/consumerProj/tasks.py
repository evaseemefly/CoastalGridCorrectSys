# + 22-08-07
# 作业 py
# 不同的作业任务
from abc import ABCMeta, abstractmethod
import datetime
import pathlib


class FileBase:
    def __init__(self, full_path: str, **kwargs):
        self.full_path = full_path
        self._path: pathlib = pathlib(full_path)

    @property
    def dir_path(self) -> str:
        return str(self._path.parent)

    @property
    def file_name(self) -> str:
        return self._path.name

    @property
    def file_ext(self) -> str:
        return self._path.suffix


class ITask(metaclass=ABCMeta):

    def __init__(self, full_path: str, dt: datetime.datetime, **kwargs):
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

    @property
    def dir_path(self) -> str:
        """
            获取存储路径
        @return:
        """
        pass

    @property
    def file_name(self) -> str:
        """
            获取文件名称
        @return:
        """
        pass

    @property
    def file_ext(self) -> str:
        """
            获取文件后缀
        @return:
        """
        pass
