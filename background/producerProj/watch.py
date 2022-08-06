from watchdog.observers import Observer
from watchdog.events import *
import time
import sys
import os
import arrow
import datetime
import logging
from settings import WATCH_SETTINGS, LOG_SETTINGS, CHILDREN_DIRS
from cache import insert_to_redis

# 日志输出的根目录
LOGGING_PATH: str = LOG_SETTINGS.get('default').get('LOGGING_PATH')
# 测试的监听路径
TEST_WATCH_PATH: str = WATCH_SETTINGS.get('default').get('WATCH_ROOT_DIR')

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


def event_to_store(event, event_type: str):
    """
        持久化
          logging
          to redis
    @param event:
    @param event_type:
    @return:
    """
    logger.info(f'file {event_type} :{event.src_path} ')
    file_data = {
        'full_path': f'{event.src_path}',
        'gmt_created': datetime.datetime.utcnow().timestamp(),
        'event_type': event_type
    }
    insert_to_redis(file_data)


class FileEventHandler(FileSystemEventHandler):

    def __init__(self):
        FileSystemEventHandler.__init__(self)
        # self._time0 = self.getTime()

    def on_moved(self, event):
        if event.is_directory:
            logger.info("directory moved from {0} to {1}".format(event.src_path, event.dest_path))
        else:
            # logger.info("file moved from {0} to {1}".format(event.src_path, event.dest_path))
            event_to_store(event, 'moved')

    def on_created(self, event):
        if event.is_directory:
            logger.info("directory created:{0}".format(event.src_path))
        else:
            # logger.info("file created:{0}".format(event.src_path))
            event_to_store(event, 'created')

    def on_deleted(self, event):
        if event.is_directory:
            logger.info("directory deleted:{0}".format(event.src_path))
        else:
            # logger.info("file deleted:{0}".format(event.src_path))
            event_to_store(event, 'deleted')

    def getTime(self):
        # 单位 s
        return arrow.utcnow().timestamp()

    # 主要监控目录下有文件修改
    def on_modified(self, event):
        """
            TODO:[*] 22-08-06
            win 下会出现上传文件结束时 修改事件会被触发两次
            测试在 linux 下是否会被执行多次
            文件创建的动作其实会触发多种事件，包括FileCreatedEvent以及FileModifiedEvent事件，触发FileEventHander中重写的on_created函数以及on_modified函数，这些事需要注意的，原因在于f=open()这样的文件操作会触发FileCreatedEvent事件，执行on_created函数，文件操作f.flush()和f.close()操作会触发FileModifiedEvent事件，执行on_modified函数。
            在windows系统下，watchdog的on_modified会被触发两次。

        @param event:
        @return:
        """
        # 监控目录下面的目录
        # time1 = self.getTime()
        # print(time1 - self._time0)
        # if (time1 - self._time0) < 0.2:
        #     exit(0)
        if event.is_directory:
            logger.info("directory modified:{0}".format(event.src_path))
        else:
            # logger.info("file modified:{0}".format(event.src_path))
            event_to_store(event, 'modified')


def watch_producer():
    """
        监听生产者
    @return:
    """
    observer = Observer()
    event_handler = FileEventHandler()
    # 监控目录
    observer.schedule(event_handler, TEST_WATCH_PATH, True)
    observer.start()
    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        observer.stop()
    observer.join()
