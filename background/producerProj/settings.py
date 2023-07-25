# 配置文件
# + 22-08-06

# watch_dog 监听配置
WATCH_SETTINGS = {
    'default': {
        'WATCH_ROOT_DIR': r'/opt/grid/data/MarineFCST',  # 监听根目录
        'WATCH_DIRS': [r'/opt/grid/data/MarineFCST/NMF/china_seas/whole',
                       r'/opt/grid/data/MarineFCST/PZJ/china_seas/ZJS/PZJ_BEN_DT_CS_grid',
                       r'/opt/grid/data/MarineFCST/REF/china_seas/DHDT/REF_BEN_DT_CS_grid',
                       r'/opt/grid/data/MarineFCST/PLN/china_seas/LNS/PLN_BEN_DT_CS_grid',
                       r'/opt/grid/data/MarineFCST/RNF/china_seas/BHDT/RNF_BEN_DT_CS_grid',
                       # 23-02-27
                       r'/opt/grid/data/MarineFCST/PFJ/china_seas/FJS/PFJ_BEN_DT_CS_grid',  # 福建
                       r'/opt/grid/data/MarineFCST/PGX/china_seas/GXS/PGX_BEN_DT_CS_grid',  # 广西
                       r'/opt/grid/data/MarineFCST/PSZ/china_seas/GDSZS/PSZ_BEN_DT_CS_grid',  # 深圳
                       r'/opt/grid/data/MarineFCST/RSF/china_seas/NHDT/RSF_BEN_DT_CS_grid',  # 南海

                       # 23-07-24
                       r'/opt/grid/data/MarineFCST/PNB/china_seas/ZJNBS/PNB_BEN_DT_CS_grid',  # 宁波
                       r'/opt/grid/data/MarineFCST/PHB/china_seas/HBS/PHB_BEN_DT_CS_grid',  # 河北
                       r'/opt/grid/data/MarineFCST/PDL/china_seas/LNDLS/PDL_BEN_DT_CS_grid',  # 大连
                       r'/opt/grid/data/MarineFCST/PTJ/china_seas/TJS/PTJ_BEN_DT_CS_grid',  # 天津
                       r'/opt/grid/data/MarineFCST/PSD/china_seas/SDS/PSD_BEN_DT_CS_grid',  # 山东
                       r'/opt/grid/data/MarineFCST/PQD/china_seas/SDQDS/PQD_BEN_DT_CS_grid',  # 青岛
                       r'/opt/grid/data/MarineFCST/PJS/china_seas/JSS/PJS_BEN_DT_CS_grid',  # 江苏
                       r'/opt/grid/data/MarineFCST/PSH/china_seas/SHS/PSH_BEN_DT_CS_grid',  # 上海
                       r'/opt/grid/data/MarineFCST/PXM/china_seas/FJXMS/PXM_BEN_DT_CS_grid',  # 厦门
                       r'/opt/grid/data/MarineFCST/PGD/china_seas/GDS/PGD_BEN_DT_CS_grid',  # 广东
                       r'/opt/grid/data/MarineFCST/PHN/china_seas/HNS/PHN_BEN_DT_CS_grid',  # 海南

                       ]
    }
}

REDIS_SETTINGS = {
    'default': {
        'key': 'watch_files',
    }
}

LOG_SETTINGS = {
    'default': {
        'LOGGING_PATH': r'./logs/logs.txt'  # 日志的输出目录
    }
}

# 子目录路径
CHILDREN_DIRS = [
    {
        'path': ''  # 对于监听根目录的相对路径
    }
]
