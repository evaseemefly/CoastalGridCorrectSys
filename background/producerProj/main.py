from watch import watch_producer
from notify import notify_producer, inotify_producer


def main():
    # watch_producer()
    notify_producer()
    # inotify_producer()
    pass


if __name__ == '__main__':
    main()
