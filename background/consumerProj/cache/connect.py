import redis
from json import dump, dumps, loads, load
from conf.settings import REDIS_SETTINGS

redis_pool = redis.ConnectionPool(host='127.0.0.1', port=6379, db=0)
redis_conn = redis.Redis(connection_pool=redis_pool)


def get_cache_conn() -> redis.Redis:
    """
        获取 缓存 连接
    @return: redis.Redis
    """
    return redis_conn


def get_lpop() -> dict:
    """
        从序列左侧取出先进的对象
    @return: 取出的对象
    """
    conn = get_cache_conn()
    list_key = REDIS_SETTINGS.get('default').get('key')
    # 若全部取完会为None
    json_temp: str = conn.lpop(list_key)
    dict_temp: dict = None
    if json_temp is not None:
        dict_temp = loads(json_temp)
    return dict_temp
