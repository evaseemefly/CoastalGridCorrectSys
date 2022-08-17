package com.nmefc.grid_monitor_service.controller;

import com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProcessInfo;
import com.nmefc.grid_monitor_service.common.TimeEnum;
import com.nmefc.grid_monitor_service.service.BaseFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public List<ProcessInfo> info(String now_dt, String[] group_codes){

        List<ProcessInfo> processInfoList = new ArrayList<>();
        if (null != group_codes && group_codes.length > 0 && null != now_dt){
            //字符串日期转换为Date
            SimpleDateFormat fmt1 =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat fmt2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = fmt1.parse(now_dt);
                List<Integer> groupCodeList = new ArrayList<>();
                for(String item: group_codes){
                    groupCodeList.add(Integer.parseInt(item));
                }
                processInfoList = baseFileInfoService.getProcessInfo(date,groupCodeList);
            } catch (ParseException e) {
                e.printStackTrace();
            }



        }else {

            return null;
        }
        return processInfoList;
    }
}
