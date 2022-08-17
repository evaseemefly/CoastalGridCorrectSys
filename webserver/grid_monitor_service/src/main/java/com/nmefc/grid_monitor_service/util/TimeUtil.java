package com.nmefc.grid_monitor_service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *@Description:时间转换工具类
 *@Param:
 *@Return:
 *@Author: QuYuan
 *@Date: 2022/8/17 21:34
 */
public class TimeUtil {
      /**
     *@Description:
     *@Param: [localTime]
     *@Return: Date
     *@Author: QuYuan
     *@Date: 2022/8/17 21:34
     */
    public static Date localToUTC(String localTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date localDate= null;
        try {
            localDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long localTimeInMillis=localDate.getTime();
        /** long时间转换成Calendar */
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(localTimeInMillis);
        /** 取得时间偏移量 */
        int zoneOffset = calendar.get(java.util.Calendar.ZONE_OFFSET);
        /** 取得夏令时差 */
        int dstOffset = calendar.get(java.util.Calendar.DST_OFFSET);
        /** 从本地时间里扣除这些差量，即可以取得UTC时间*/
        calendar.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        /** 取得的时间就是UTC标准时间 */
        Date utcDate=new Date(calendar.getTimeInMillis());
        return utcDate;
    }


    /**
     *@Description:utc时间转成local时间
     *@Param: [utcTime]
     *@Return: java.util.Date
     *@Author: QuYuan
     *@Date: 2022/8/17 21:47
     */
    public static Date utcToLocal(String utcTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;
        try {
            utcDate = sdf.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.setTimeZone(TimeZone.getDefault());
        Date locatlDate = null;
        String localTime = sdf.format(utcDate.getTime());
        try {
            locatlDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locatlDate;
    }
/**
 *@Description:获得指定日期当日最小时刻
 *@Param: [date]
 *@Return: java.util.Date
 *@Author: QuYuan
 *@Date: 2022/8/17 21:48
 */
 public static Date getZero(Date date) throws ParseException {

     Calendar calendar = Calendar.getInstance();
     calendar.setTime(date);
     calendar.set(Calendar.HOUR_OF_DAY, 0);
     calendar.set(Calendar.MINUTE, 0);
     calendar.set(Calendar.SECOND, 0);
     return calendar.getTime();

 }


    /**
     *@Description:获得指定日期当日最大时刻
     *@Param: [date]
     *@Return: java.util.Date
     *@Author: QuYuan
     *@Date: 2022/8/17 21:48
     */
    public static Date getEnd(Date date) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();

    }


    private TimeUtil() {
    }
}
