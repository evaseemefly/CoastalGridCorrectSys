package com.nmefc.grid_monitor_service.service;

import com.nmefc.grid_monitor_service.bean.resultBean.*;

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
    /**
     *@Description:获取产品简略统计信息
     *@Param: []
     *@Return: com.nmefc.grid_monitor_service.bean.resultBean.StatisticsMainInfo
     *@Author: QuYuan
     *@Date: 2022/8/17 20:44
     */
    StatisticsMainInfo getStatisticsMainInfo();
    /**
     *@Description:获取指定日期当天文件统计信息
     *@Param: [date]
     *@Return: com.nmefc.grid_monitor_service.bean.resultBean.TodayFileInfo
     *@Author: QuYuan
     *@Date: 2022/8/17 21:28
     */
    TodayFileInfo getOneDayFileInfo(Date date);

    /**
     *@Description: 获取最近X天的文件信息
     *@Param: [days]
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.FileInfo>
     *@Author: QuYuan
     *@Date: 2022/8/17 23:20
     */
    List<FileInfo> getFileInfo(Integer days);
}
