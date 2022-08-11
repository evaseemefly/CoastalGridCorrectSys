# 配置文件

DATABASES = {
    'default': {
        'ENGINE': 'mysqldb',  # 数据库引擎
        'NAME': 'grid_sys',  # 数据库名
        'USER': 'root',  # 账号
        'PASSWORD': '',
        'HOST': '127.0.0.1',  # HOST
        'POST': 3306,  # 端口
        'OPTIONS': {
            "init_command": "SET foreign_key_checks = 0;",
        },
    }
}

REDIS_SETTINGS = {
    'default': {
        'key': 'watch_files'
    }
}