from enum import Enum, unique


@unique
class IssureEnum(Enum):
    """
         发布单位枚举——固定
    """
    NMF = 1001
    PZJ = 1013
    REF = 1003
    RNF = 1002  # 新加入的北海区台
    PLN = 1005  # 辽宁省台


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
    # TODO:[-] 22-08-24 新添加的区域
    ZJS = 4002  # 浙江省预报区域
    DHDT = 4003  # 东海预报区域
    BHDT = 4004  # 北海预报区域
    LNS = 4005  # 辽宁预报区域
    NULL = 9999


@unique
class ForecastElementEnum(Enum):
    """
        预报要素
    """
    SSW = 5001
    WAV = 5002
    OCU = 5003
    SST = 5004
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
    L2 = 6103
    L3 = 6104
    L4 = 6105
    L5 = 6106
    L99 = 9999
