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
