package com.nmefc.grid_monitor_service.controller;

import com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo;
import com.nmefc.grid_monitor_service.service.BaseFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    BaseFileInfoService baseFileInfoService;
    /**
     *@Description:获取所有的机构列表（当前有上传产品的机构）
     *@Param: []
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo>
     *@Author: QuYuan
     *@Date: 2022/8/15 19:41
     */
    @GetMapping("/group/list")
    public List<GroupInfo> list(){
        return baseFileInfoService.getGroupInfo();
    }
    /**
     *@Description:获取指定机构的作业流程信息
     *@Param: [group_code, now_dt]
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo>
     *@Author: QuYuan
     *@Date: 2022/8/16 8:59
     */
    @GetMapping("/group/info")
    public List<GroupInfo> info(String group_code, Date now_dt){

        if (null != group_code && null != now_dt){
            SimpleDateFormat df = new SimpleDateFormat("HH");
            String str = df.format(now_dt);
            int hour = Integer.parseInt(str);
            if (hour <= 4) {
        
            }
        }else {
            return null;
        }
        return baseFileInfoService.getGroupInfo();
    }
}
