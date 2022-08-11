from apscheduler.schedulers.blocking import BlockingScheduler
from datetime import datetime
from core.tasks import WatchFileTask


def job():
    WatchFileTask().to_do()


def to_schedule():
    scheduler = BlockingScheduler()
    scheduler.add_job(job, 'cron', minute='*/1')
    scheduler.start()
