import pyinotify
from settings import WATCH_SETTINGS, LOG_SETTINGS, CHILDREN_DIRS

WATCH_DIR: str = WATCH_SETTINGS.get('default').get('WATCH_ROOT_DIR')

# 监控多个事件
multi_event = pyinotify.IN_CLOSE_NOWRITE
wm = pyinotify.WatchManager()  # 创建WatchManager对象


class MyEventHandler(pyinotify.ProcessEvent):  # 定制化事件处理类，注意继承
    def process_IN_OPEN(self, event):  # 必须为process_事件名称，event表示事件对象
        #
        print('OPEN', event.pathname)  # event.pathname 表示触发事件的文件路径

    def process_IN_CLOSE_NOWRITE(self, event):
        # 结束写入时执行之前 watchdog 中的相关操作
        print('CLOSE_NOWRITE', event.pathname)


def notify_producer():
    handler = MyEventHandler()  # 实例化我们定制化后的事件处理类
    notifier = pyinotify.Notifier(wm, handler)  # 在notifier实例化时传入,notifier会自动执行
    wm.add_watch(WATCH_DIR, multi_event)  # 添加监控的目录，及事件
    notifier.loop()
