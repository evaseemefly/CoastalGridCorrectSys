from sqlalchemy import Column, Date, Float, ForeignKey, Integer, text
from sqlalchemy.dialects.mysql import DATETIME, INTEGER, TINYINT, VARCHAR
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import ForeignKey, Sequence, MetaData, Table
from sqlalchemy.sql import func
from sqlalchemy.orm import relationship, sessionmaker
from datetime import datetime
# geoalchemy2 相关y
# from geoalchemy2 import Geometry

# 项目配置
from conf.settings import DATABASES
from db.db import DbFactory

engine = DbFactory().engine

# 生成基类
BaseMeta = declarative_base()
md = MetaData(bind=engine)  # 引用MetaData
metadata = BaseMeta.metadata


class BaseFileInfoModel(BaseMeta):
    """
        基础文件信息model
    """
    __tablename__ = 'base_file_info'
    id = Column(Integer, primary_key=True)
    gmt_created = Column(DATETIME(fsp=6), default=datetime.utcnow)
    gmt_modified = Column(DATETIME(fsp=6), default=datetime.utcnow)
    is_del = Column(TINYINT(1), nullable=False, server_default=text("'0'"), default=0)
    # type_id = Column(Integer, nullable=False)
    # district_id = Column(Integer, nullable=False)
    issurer_id = Column(Integer, nullable=False)  # 发布单位 id
    forecast_time = Column(DATETIME, nullable=False)  # 预报时间
    update_time = Column(DATETIME, nullable=False)  # 修改时间
    # level = Column(Integer, nullable=False)  # 数据级别
    # valid = Column(Integer, nullable=False)  #
    product_type = Column(Integer, nullable=False)  # 产品类型
    # time_resolved = Column(Integer, nullable=False)  #
    forecast_type = Column(Integer, nullable=False)  # 预报类型
    forecast_area = Column(Integer, nullable=False)  # 预报区域
    forecast_period = Column(Integer, nullable=False)  # 预报时效
    forecast_interval = Column(Integer, nullable=False)  # 预报时间间隔
    forecast_element = Column(Integer, nullable=False)  # 预报要素
    revisal_type = Column(Integer, nullable=False)  # 订正方法
    level = Column(Integer, nullable=False)  # 数据级别
    file_name = Column(VARCHAR(500), nullable=False)
    file_full_name = Column(VARCHAR(500), nullable=False)
    file_ext = Column(VARCHAR(10), nullable=False)
    size = Column(Float, nullable=False)
    path = Column(VARCHAR(500), nullable=False)
    is_standard = Column(Integer, nullable=False)  # 是否标准化
    event_type = Column(VARCHAR(20), nullable=False)
    # case_state = Column(Integer, nullable=False)
    # tid = Column(Integer, nullable=False)
