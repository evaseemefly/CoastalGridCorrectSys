# + 22-08-06 加入的缓存 py
import redis
import datetime
import json
from settings import REDIS_SETTINGS

redis_pool = redis.ConnectionPool(host='127.0.0.1', port=6379, db=0)
redis_conn = redis.Redis(connection_pool=redis_pool)

#
REDIS_KEY = REDIS_SETTINGS.get('default').get('key')


# 测试添加 文件列表集合
# test_file = {
#     'file_name': r'E:\01data\99test\新建 BMP 图像 - 副本 (3).bmp',
#     'gmt_created': datetime.datetime.utcnow().timestamp()
# }
# json_data = json.dumps(test_file)
#
# v = redis_conn.lpush('watch_files', json_data)


def insert_to_redis(file_data: dict) -> bool:
    """
        将监听到的文件信息 写入 redis -> watch_files 列表中
    @param file_data:
    @return:
    """
    is_ok: bool = False
    try:
        json_data = json.dumps(file_data)
        v = redis_conn.lpush(REDIS_KEY, json_data)
        is_ok = True
    except Exception as e:
        is_ok = False
    return is_ok
