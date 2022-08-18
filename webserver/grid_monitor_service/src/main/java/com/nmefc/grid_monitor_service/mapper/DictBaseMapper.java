package com.nmefc.grid_monitor_service.mapper;

import com.nmefc.grid_monitor_service.bean.DictBase;
import com.nmefc.grid_monitor_service.bean.DictBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictBaseMapper {
    long countByExample(DictBaseExample example);

    int deleteByExample(DictBaseExample example);

    int deleteByPrimaryKey(Integer code);

    int insert(DictBase record);

    int insertSelective(DictBase record);

    List<DictBase> selectByExample(DictBaseExample example);

    DictBase selectByPrimaryKey(Integer code);

    int updateByExampleSelective(@Param("record") DictBase record, @Param("example") DictBaseExample example);

    int updateByExample(@Param("record") DictBase record, @Param("example") DictBaseExample example);

    int updateByPrimaryKeySelective(DictBase record);

    int updateByPrimaryKey(DictBase record);
}