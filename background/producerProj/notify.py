import pyinotify
import pathlib
import logging
import arrow

from cache import insert_to_redis
from settings import WATCH_SETTINGS, LOG_SETTINGS, CHILDREN_DIRS

WATCH_DIR: str = WATCH_SETTINGS.get('default').get('WATCH_ROOT_DIR')
# 日志输出的根目录
LOGGING_PATH: str = LOG_SETTINGS.get('default').get('LOGGING_PATH')

# 创建一个logger，设置日志
logger = logging.getLogger('MonitorDir')
logger.setLevel(logging.DEBUG)

# 创建一个handler，用于写入日志文件
fh = logging.FileHandler(LOGGING_PATH)
fh.setLevel(logging.DEBUG)

# 再创建一个handler，用于输出到控制台
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)

# 定义handler的输出格式
formatter = logging.Formatter(
    '[%(asctime)s] [%(thread)d] [%(filename)s] [line: %(lineno)d][%(levelname)s] ## %(message)s')
fh.setFormatter(formatter)
ch.setFormatter(formatter)

# 给logger添加handler
logger.addHandler(fh)
logger.addHandler(ch)

# 监控多个事件
multi_event = pyinotify.IN_CLOSE_WRITE
wm = pyinotify.WatchManager()  # 创建WatchManager对象


def is_file(pathname: str) -> bool:
    """
        判断是否为文件
    @param pathname:
    @return:
    """
    return pathlib.Path(pathname).is_file()


def event_to_store(full_name: str, event_type: str):
    """
        持久化
          logging
          to redis
    @param event:
    @param event_type:
    @return:
    """
    logger.info(f'file {event_type} :{full_name} ')
    # TODO:[-] 22-08-11 注意此处获取时间戳使用 arrow 获取
    file_data = {
        'full_path': f'{full_name}',
        # 'gmt_created': datetime.datetime.utcnow().timestamp(),
        'size': pathlib.Path(full_name).stat().st_size if pathlib.Path(full_name).is_file() else 0,
        'gmt_created': arrow.get().timestamp(),
        'event_type': event_type
    }
    insert_to_redis(file_data)


class MyEventHandler(pyinotify.ProcessEvent):  # 定制化事件处理类，注意继承
    def process_IN_OPEN(self, event):  # 必须为process_事件名称，event表示事件对象
        #
        pathname: str = event.pathname

        if is_file(pathname):
            logger.info("wathing in OPEN:{0}".format(pathname))
            event_to_store(pathname, 'created')

    def process_IN_CLOSE_NOWRITE(self, event):
        # 结束写入时执行之前 watchdog 中的相关操作
        pathname: str = event.pathname

        if is_file(pathname):
            logger.info("wathing in CLOSE_NOWRITE:{0}".format(pathname))
            # event_to_store(pathname, 'modified')

    def process_IN_CLOSE_WRITE(self, event):
        # 结束写入时执行之前 watchdog 中的相关操作
        pathname: str = event.pathname

        if is_file(pathname):
            logger.info("wathing in CLOSE_WRITE:{0}".format(pathname))
            event_to_store(pathname, 'modified')


def notify_producer():
    handler = MyEventHandler()  # 实例化我们定制化后的事件处理类
    notifier = pyinotify.Notifier(wm, handler)  # 在notifier实例化时传入,notifier会自动执行
    # notifier = pyinotify.Notifier(wm)
    wm.add_watch(WATCH_DIR, multi_event, rec=True)  # 添加监控的目录，及事件
    # wm.watch_transient_file(WATCH_DIR, pyinotify.IN_CLOSE_WRITE, MyEventHandler)
    notifier.loop()


class ProcessTransientFile(pyinotify.ProcessEvent):

    def process_IN_MODIFY(self, event):
        # We have explicitely registered for this kind of event.
        print
        '\t', event.pathname, ' -> written'

    def process_default(self, event):
        # Implicitely IN_CREATE and IN_DELETE are watched too. You can
        # ignore them and provide an empty process_default or you can
        # process them, either with process_default or their dedicated
        # method (process_IN_CREATE, process_IN_DELETE) which would
        # override process_default.
        print
        'default: ', event.maskname


def inotify_producer():
    watchManager = pyinotify.WatchManager()
    notifier = pyinotify.Notifier(watchManager)
    # In this case you must give the class object (ProcessTransientFile)
    # as last parameter not a class instance.
    watch_dir = r'/opt/grid/data/MarineFCST'
    watch_dirs = [r'/opt/grid/data/MarineFCST/NMF/china_seas/whole/NMF_BEN_DT_CS_grid',
                  r'/opt/grid/data/MarineFCST/PZJ/china_seas/ZJS/PZJ_BEN_DT_CS_grid',
                  r'/opt/grid/data/MarineFCST/REF/china_seas/DHDT/REF_BEN_DT_CS_grid']
    # for temp_path in watch_dirs:
    #     watchManager.watch_transient_file(temp_path,
    #                                       pyinotify.IN_CLOSE_WRITE, ProcessTransientFile)
    watchManager.watch_transient_file(watch_dir,
                                      pyinotify.IN_CLOSE_WRITE, ProcessTransientFile)
    notifier.loop()
