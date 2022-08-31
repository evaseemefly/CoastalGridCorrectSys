package com.nmefc.grid_monitor_service.controller;

import com.nmefc.grid_monitor_service.bean.resultBean.ElementInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProcessInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProductLevelInfoDetail;
import com.nmefc.grid_monitor_service.common.TimeEnum;
import com.nmefc.grid_monitor_service.service.BaseFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description: 流程控制器
 * @Param:
 * @Return:
 * @Author: QuYuan
 * @Date: 2022/8/17 20:35
 */
@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    BaseFileInfoService baseFileInfoService;

    /**
     * @Description:获取所有的机构列表（当前有上传产品的机构）
     * @Param: []
     * @Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo>
     * @Author: QuYuan
     * @Date: 2022/8/15 19:41
     */
    @GetMapping("/group/list")
    public List<GroupInfo> list() {
        return baseFileInfoService.getGroupInfo();
    }

    /**
     * @Description:获取指定机构的作业流程信息
     * @Param: [group_code, now_dt]
     * @Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo>
     * @Author: QuYuan
     * @Date: 2022/8/16 8:59
     */
    @GetMapping("/group/info")
    public List<ProcessInfo> info(String now_dt, @RequestParam(value = "group_code[]") String[] group_codes) {

        List<ProcessInfo> processInfoList = new ArrayList<>();
        if (null != group_codes && group_codes.length > 0 && null != now_dt) {
            //字符串日期转换为Date
            // TODO:[-] 22-08-20 传入的时间格式为:2022-08-19T10:00:000Z 修改 format 为 .SSS'Z'
            SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = fmt1.parse(now_dt);
                List<Integer> groupCodeList = new ArrayList<>();
                for (String item : group_codes) {
                    groupCodeList.add(Integer.parseInt(item));
                }
                processInfoList = baseFileInfoService.getProcessInfo(date, groupCodeList);
            } catch (ParseException e) {
                e.printStackTrace();
            }


        } else {

            return null;
        }
        return processInfoList;
    }
    /**
     *@Description:获取指定时间要素的状态列表
     *@Param: [element_type, now_dt, target_dt]
     *@Return: com.nmefc.grid_monitor_service.bean.resultBean.ElementInfo
     *@Author: QuYuan
     *@Date: 2022/8/31 11:18
     */
    @GetMapping("/element/info")
    public ElementInfo elementInfo(Integer element_type, String now_dt, @Nullable String target_dt){
        if(null == element_type && null == now_dt){return null;}

        SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = null;
        try {

            if (null != target_dt){
                date = fmt1.parse(target_dt);

            }else {
                date = fmt1.parse(now_dt);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }


        return baseFileInfoService.getElementInfo(element_type,date);

    }
    /**
     *@Description:获取指定海区，指定要素的当前作业状态
     *@Param: [elementType, now_dt, area, target_dt]
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.resultBean.ProductLevelInfoDetail>
     *@Author: QuYuan
     *@Date: 2022/8/31 20:55
     */
    @GetMapping("/element/area/step")
    public List<ProductLevelInfoDetail> step(Integer elementType, String now_dt, Integer area,@Nullable String target_dt){
        if(null == elementType && null == now_dt && null == area){return null;}

        SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = null;
        try {
            if (null != target_dt){
                date = fmt1.parse(target_dt);
            }else {
                date = fmt1.parse(now_dt);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return baseFileInfoService.getProductInfoDetailByElement(elementType,date, area);
    }
}
