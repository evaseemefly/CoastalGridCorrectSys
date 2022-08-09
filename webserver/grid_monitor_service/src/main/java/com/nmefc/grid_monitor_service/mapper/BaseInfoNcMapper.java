package com.nmefc.grid_monitor_service.mapper;

import com.nmefc.grid_monitor_service.bean.BaseInfoNc;
import com.nmefc.grid_monitor_service.bean.BaseInfoNcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseInfoNcMapper {
    long countByExample(BaseInfoNcExample example);

    int deleteByExample(BaseInfoNcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseInfoNc record);

    int insertSelective(BaseInfoNc record);

    List<BaseInfoNc> selectByExample(BaseInfoNcExample example);

    BaseInfoNc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseInfoNc record, @Param("example") BaseInfoNcExample example);

    int updateByExample(@Param("record") BaseInfoNc record, @Param("example") BaseInfoNcExample example);

    int updateByPrimaryKeySelective(BaseInfoNc record);

    int updateByPrimaryKey(BaseInfoNc record);
}