package com.nmefc.grid_monitor_service.controller;

import com.nmefc.grid_monitor_service.bean.resultBean.FileInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.StatisticsMainInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.TodayFileInfo;
import com.nmefc.grid_monitor_service.service.BaseFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 *@Description: 统计控制器
 *@Param:
 *@Return:
 *@Author: QuYuan
 *@Date: 2022/8/17 20:35
 */
@CrossOrigin
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    BaseFileInfoService baseFileInfoService;
    /**
     *@Description:获取产品简略统计信息
     *@Param: []
     *@Return: com.nmefc.grid_monitor_service.bean.resultBean.StatisticsMainInfo
     *@Author: QuYuan
     *@Date: 2022/8/17 21:27
     */
    @GetMapping("/product/main")
    public StatisticsMainInfo getMainInfo(){
        return baseFileInfoService.getStatisticsMainInfo();
    }
    /**
     *@Description:获取当日文件统计信息
     *@Param: []
     *@Return: com.nmefc.grid_monitor_service.bean.resultBean.TodayFileInfo
     *@Author: QuYuan
     *@Date: 2022/8/17 22:41
     */
    @GetMapping("/product/file")
    public TodayFileInfo getTodayFileInfo(){
        return baseFileInfoService.getOneDayFileInfo(new Date());
    }


    @GetMapping("/product/7days")
    public List<FileInfo> get7daysFileInfo(){
        return baseFileInfoService.getFileInfo(new Integer(7));
    }
}
