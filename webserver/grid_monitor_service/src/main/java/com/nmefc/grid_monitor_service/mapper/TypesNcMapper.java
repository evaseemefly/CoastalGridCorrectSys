package com.nmefc.grid_monitor_service.mapper;

import com.nmefc.grid_monitor_service.bean.TypesNc;
import com.nmefc.grid_monitor_service.bean.TypesNcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypesNcMapper {
    long countByExample(TypesNcExample example);

    int deleteByExample(TypesNcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TypesNc record);

    int insertSelective(TypesNc record);

    List<TypesNc> selectByExample(TypesNcExample example);

    TypesNc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TypesNc record, @Param("example") TypesNcExample example);

    int updateByExample(@Param("record") TypesNc record, @Param("example") TypesNcExample example);

    int updateByPrimaryKeySelective(TypesNc record);

    int updateByPrimaryKey(TypesNc record);
}