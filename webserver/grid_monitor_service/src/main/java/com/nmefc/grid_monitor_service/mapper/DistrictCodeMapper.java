package com.nmefc.grid_monitor_service.mapper;

import com.nmefc.grid_monitor_service.bean.DistrictCode;
import com.nmefc.grid_monitor_service.bean.DistrictCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistrictCodeMapper {
    long countByExample(DistrictCodeExample example);

    int deleteByExample(DistrictCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DistrictCode record);

    int insertSelective(DistrictCode record);

    List<DistrictCode> selectByExample(DistrictCodeExample example);

    DistrictCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DistrictCode record, @Param("example") DistrictCodeExample example);

    int updateByExample(@Param("record") DistrictCode record, @Param("example") DistrictCodeExample example);

    int updateByPrimaryKeySelective(DistrictCode record);

    int updateByPrimaryKey(DistrictCode record);
}