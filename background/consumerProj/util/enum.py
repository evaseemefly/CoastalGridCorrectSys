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
    # 23-02-28 新添加
    PLN = 1005  # 辽宁省台
    PFJ = 1015  # 福建省台
    PGX = 1019  # 广西省台
    PSZ = 1018  # 深圳省台
    RSF = 1004  # 南海省台
    # 23-07-24
    PNB = 1014  # 宁波
    PHB = 1007  # 河北
    PDL = 1006  # 大连
    PTJ = 1008  # 天津
    PSD = 1009  # 山东
    PQD = 1010  # 青岛
    PJS = 1011  # 江苏
    PSH = 1012  # 上海
    PXM = 1016  # 厦门
    PGD = 1017  # 广东
    PHN = 1020  # 海南


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
    # 23-02-28 新添加
    FJS = 4006  # 福建
    GXS = 4007  # 广西
    GDSZS = 4008  # 深圳
    NHDT = 4009  # 南海
    # 23-07-24
    ZJNBS = 4010  # 宁波
    HBS = 4011  # 河北
    LNDLS = 4012  # 大连
    TJS = 4013  # 天津
    SDS = 4014  # 山东
    SDQDS = 4015  # 青岛
    JSS = 4016  # 江苏
    SHS = 4017  # 上海
    FJXMS = 4018  # 厦门
    GDS = 4019  # 广东
    HNS = 4020  # 海南
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
