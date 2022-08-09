package com.nmefc.grid_monitor_service.mapper;

import com.nmefc.grid_monitor_service.bean.TaskStatus;
import com.nmefc.grid_monitor_service.bean.TaskStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskStatusMapper {
    long countByExample(TaskStatusExample example);

    int deleteByExample(TaskStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskStatus record);

    int insertSelective(TaskStatus record);

    List<TaskStatus> selectByExample(TaskStatusExample example);

    TaskStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskStatus record, @Param("example") TaskStatusExample example);

    int updateByExample(@Param("record") TaskStatus record, @Param("example") TaskStatusExample example);

    int updateByPrimaryKeySelective(TaskStatus record);

    int updateByPrimaryKey(TaskStatus record);
}