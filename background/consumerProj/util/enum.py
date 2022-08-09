from enum import Enum, unique


@unique
class IssureEnum(Enum):
    """
         发布单位枚举——固定
    """
    NMF = 1001


@unique
class ForecastTypeEnum(Enum):
    """
        预报类型——固定
    """
    BEN = 2001


@unique
class ProductTypeEunm(Enum):
    """
        产品类型
    """
    OSM = 3001


@unique
class ForecastAreaEnum(Enum):
    """
        预报区域
    """
    CSDT = 4001
    NULL = 9999


@unique
class ForecastElementEnum(Enum):
    """
        预报要素
    """
    SSW = 5001
    NULL = 9999


@unique
class RevisalTypeEnum(Enum):
    """
        订正方法
    """
    # 无订正
    UN = 6001
    # 主观订正
    MANUAL = 6002
    # 客观订正
    OBJECTIVE = 6003


@unique
class LevelEnum(Enum):
    """
        数据级别
    """
    L0 = 6101
    L1 = 6102
    L3 = 6103
    L4 = 6104
    L5 = 6105
    L99 = 9999
