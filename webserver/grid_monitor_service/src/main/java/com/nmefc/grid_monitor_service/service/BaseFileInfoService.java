package com.nmefc.grid_monitor_service.service;

import com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProcessInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProductInfo;

import java.util.Date;
import java.util.List;

public interface BaseFileInfoService {
    /**
     *@Description: 获取所有产品列表
     *@Param: []
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.ProductInfo>
     *@Author: QuYuan
     *@Date: 2022/8/15 18:20
     */
    List<ProductInfo> getProductInfo();
    /**
     *@Description:获取所有的机构列表（当前有上传产品的机构）
     *@Param: []
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo>
     *@Author: QuYuan
     *@Date: 2022/8/15 19:40
     */
    List<GroupInfo> getGroupInfo();
    /**
     *@Description: 获取指定机构的作业流程信息
     *@Param: [date（日期）, groupCode（机构代码）]
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.ProcessInfo>
     *@Author: QuYuan
     *@Date: 2022/8/16 9:22
     */
    List<ProcessInfo> getProcessInfo(Date date, List<Integer> groupCodeList);
}
