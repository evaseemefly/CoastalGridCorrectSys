# 配置文件
# + 22-08-06

# watch_dog 监听配置
WATCH_SETTINGS = {
    'default': {
        'WATCH_ROOT_DIR': r'/Users/evaseemefly/03data/03grid_data',  # 监听根目录
        'WATCH_DIRS': [r'/Users/evaseemefly/03data/03grid_data/NMF', r'/Users/evaseemefly/03data/03grid_data/PZJ',
                       r'/Users/evaseemefly/03data/03grid_data/REF']
    }
}

REDIS_SETTINGS = {
    'default': {
        'key': 'watch_files'
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
