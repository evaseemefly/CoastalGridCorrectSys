package com.nmefc.grid_monitor_service.bean.middleBean;

import java.util.List;

public interface Process {
     /**
      *@Description:获取流程环节集合
      *@Param: []
      *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.middleBean.StepInfo>
      *@Author: QuYuan
      *@Date: 2022/8/17 15:16
      */
     List<StepInfo> init();
     /**
      *@Description:获取流程环节对于的文件级别（L1-L5）集合
      *@Param: []
      *@Return: java.lang.String[]
      *@Author: QuYuan
      *@Date: 2022/8/17 15:16
      */
     String[] getLevel_list();
}
