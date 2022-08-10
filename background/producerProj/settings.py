# 配置文件
# + 22-08-06

# watch_dog 监听配置
WATCH_SETTINGS = {
    'default': {
        'WATCH_ROOT_DIR': r'E:\01data\99test'  # 监听根目录
    }
}

REDIS_SETTINGS = {
    'default': {
        'key': 'watch_files'
    }
}

LOG_SETTINGS = {
    'default': {
        'LOGGING_PATH': r'D:\01Proj\CoastalGridCorrectSys\background\producerProj\logs\logs.txt'  # 日志的输出目录
    }
}

# 子目录路径
CHILDREN_DIRS = [
    {
        'path': ''  # 对于监听根目录的相对路径
    }
]
