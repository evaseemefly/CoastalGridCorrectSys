package com.nmefc.grid_monitor_service.mapper;

import com.nmefc.grid_monitor_service.bean.BaseFileInfo;
import com.nmefc.grid_monitor_service.bean.BaseFileInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseFileInfoMapper {
    List<BaseFileInfo> getAllElements();

    List<BaseFileInfo> getAllGroups();

    long countByExample(BaseFileInfoExample example);

    int deleteByExample(BaseFileInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseFileInfo record);

    int insertSelective(BaseFileInfo record);

    List<BaseFileInfo> selectByExample(BaseFileInfoExample example);

    BaseFileInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseFileInfo record, @Param("example") BaseFileInfoExample example);

    int updateByExample(@Param("record") BaseFileInfo record, @Param("example") BaseFileInfoExample example);

    int updateByPrimaryKeySelective(BaseFileInfo record);

    int updateByPrimaryKey(BaseFileInfo record);
}