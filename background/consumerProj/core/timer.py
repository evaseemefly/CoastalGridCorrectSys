from apscheduler.schedulers.blocking import BlockingScheduler
from datetime import datetime


def job():
    print(datetime.utcnow())


def to_schedule():
    scheduler = BlockingScheduler()
    scheduler.add_job(job, 'cron', minute='*/1')
    scheduler.start()
