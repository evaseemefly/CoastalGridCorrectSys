package com.nmefc.grid_monitor_service.service.serviceImpl;

import com.nmefc.grid_monitor_service.bean.BaseFileInfo;
import com.nmefc.grid_monitor_service.bean.BaseFileInfoExample;
import com.nmefc.grid_monitor_service.bean.DictBase;
import com.nmefc.grid_monitor_service.bean.DictBaseExample;
import com.nmefc.grid_monitor_service.bean.middleBean.*;
import com.nmefc.grid_monitor_service.bean.middleBean.Process;
import com.nmefc.grid_monitor_service.bean.resultBean.*;
import com.nmefc.grid_monitor_service.common.ElementEnum;
import com.nmefc.grid_monitor_service.common.ProcessEnum;
import com.nmefc.grid_monitor_service.common.ProductSum;
import com.nmefc.grid_monitor_service.mapper.BaseFileInfoMapper;
import com.nmefc.grid_monitor_service.mapper.DictBaseMapper;
import com.nmefc.grid_monitor_service.service.BaseFileInfoService;
import com.nmefc.grid_monitor_service.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service("baseFileInfoService")
public class BaseFileInfoServiceImpl implements BaseFileInfoService {
    @Autowired
    BaseFileInfoMapper baseFileInfoMapper;
    @Autowired
    DictBaseMapper dictBaseMapper;

    @Override
    public List<ProductInfo> getProductInfo() {

        List<ProductInfo> productInfoList = new ArrayList<>();
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();
        try{
            baseFileInfoList = baseFileInfoMapper.getAllElements();
        }catch (Exception e){
            throw e;
        }
        List<DictBase> dictBaseList = new ArrayList<>();
        DictBaseExample dictBaseExample = new DictBaseExample();
        try {
            dictBaseList = dictBaseMapper.selectByExample(dictBaseExample);
        }catch (Exception e){
            throw e;
        }
        if (dictBaseList.size()>0 && baseFileInfoList.size()>0){
            for(BaseFileInfo item : baseFileInfoList){
                for(DictBase dictItem : dictBaseList){
                    if (item.getForecastElement().equals(dictItem.getCode())){
                        ProductInfo productInfo = new ProductInfo(item.getForecastElement(),dictItem.getRemarks());
                        productInfoList.add(productInfo);
                    }
                }
            }
        }

        return productInfoList;
    }

    @Override
    public List<GroupInfo> getGroupInfo() {
        List<GroupInfo> groupInfoList = new ArrayList<>();
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();
        try{
            baseFileInfoList = baseFileInfoMapper.getAllGroups();
        }catch (Exception e){
            throw e;
        }
        List<DictBase> dictBaseList = new ArrayList<>();
        DictBaseExample dictBaseExample = new DictBaseExample();
        try {
            dictBaseList = dictBaseMapper.selectByExample(dictBaseExample);
        }catch (Exception e){
            throw e;
        }
        if (dictBaseList.size()>0 && baseFileInfoList.size()>0){
            for(BaseFileInfo item : baseFileInfoList){
                for(DictBase dictItem : dictBaseList){
                    if (item.getIssurerId().equals(dictItem.getCode())){
                        GroupInfo groupInfo = new GroupInfo(item.getIssurerId(),dictItem.getRemarks());
                        groupInfoList.add(groupInfo);
                    }
                }
            }
        }

        return groupInfoList;
    }

    @Override
    public List<ProcessInfo> getProcessInfo(Date date, List<Integer> groupCodeList) {
        List<ProcessInfo> processInfoList = new ArrayList<>();
        //1.获取字典表, 后面查询字典不需要再去访问数据库
        DictBaseExample dictBaseExample = new DictBaseExample();
        List<DictBase> dictBaseList = dictBaseMapper.selectByExample(dictBaseExample);

        //2.获取传入时间前一天的时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        Date startDate = calendar.getTime();

        for(Integer code : groupCodeList){
            //3. 判断此时获取的机构是第几级预报机构
            DictBase dictBase = dictBaseList.stream().filter((item) -> item.getCode().equals(code)).findFirst().get();
            Integer pid = dictBase.getPid();
            //3.1 得到当前机构的流程配置信息
            List<StepInfo> step_list = getStepByPid(pid);

            //3.2获取该机构的流程环节对于的文件等级集合（L1-L5）
            String[] level_list = getLevelByPid(pid);
            List<BaseFileInfo> baseFileInfoList = new ArrayList<>();

            BaseFileInfoExample baseFileInfoExample = new BaseFileInfoExample();
            BaseFileInfoExample.Criteria criteria =  baseFileInfoExample.createCriteria();
//            System.out.println(startDate);
//            System.out.println(date);

            //检索机构ID等于传入的ID，并且时间在传入时间前24小时的数据
            criteria.andIssurerIdEqualTo(code).andForecastTimeBetween(startDate,date);
            try{
                baseFileInfoList = baseFileInfoMapper.selectByExample(baseFileInfoExample);
                //去掉文件名重复的：因为用户多次上传同一文件，记录每上传1次会增加1条，这里需要去重（去掉文件名同名记录）
                baseFileInfoList = baseFileInfoList.stream().collect(Collectors
                        .collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseFileInfo::getFileFullName))),
                                ArrayList::new));
            }catch (Exception e){
                throw e;
            }



            //4.数据处理:按照产品流程进行拆分。各个流程执行以下
            if(baseFileInfoList.size()>0) {
                //4.1 按照流程拆分
                Map<Integer, List<BaseFileInfo>> groupByLevelList = baseFileInfoList.stream().collect(Collectors.groupingBy(BaseFileInfo::getLevel));

                //4.2遍历每一个流程环节

                for(StepInfo stepInfo:step_list){
                    //4.3 判断流程内，要素是否全
                    Integer index  = Integer.parseInt(level_list[stepInfo.getStep_index()-1]);
                    List<BaseFileInfo> StepFileList = new ArrayList<>();
                    StepFileList = groupByLevelList.get(index);
                    if (null == StepFileList){
                        stepInfo.setStep_state(Integer.parseInt(ProcessEnum.FAIL.getValue()));
                    }else {
                        List<String> missElementList = checkElements(StepFileList);
                        if (missElementList.size() > 0) {
                            stepInfo.setStep_state(Integer.parseInt(ProcessEnum.WAIT.getValue()));
                        } else {
                            stepInfo.setStep_state(Integer.parseInt(ProcessEnum.SUCCESS.getValue()));
                        }
                    }
                }

            }
            //配置返回变量，此时还未录入流程状态信息（step_state)
            ProcessInfo processInfo = new ProcessInfo(code.toString(),dictBase.getRemarks(),step_list);
            processInfoList.add(processInfo);
        }




        return processInfoList;
    }

    @Override
    public StatisticsMainInfo getStatisticsMainInfo() {
        //1. 获取机构数量
        List<GroupInfo> groupInfoList = new ArrayList<>();
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();
        groupInfoList = getGroupInfo();
        //2. 获取产品数量
        BaseFileInfoExample baseFileInfoExample = new BaseFileInfoExample();
        baseFileInfoList = baseFileInfoMapper.selectByExample(baseFileInfoExample);
        //去掉文件名重复的：因为用户多次上传同一文件，记录每上传1次会增加1条，这里需要去重（去掉文件名同名记录）
        baseFileInfoList = baseFileInfoList.stream().collect(Collectors
                .collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseFileInfo::getFileFullName))),
                        ArrayList::new));
        int count = baseFileInfoList.size();
        //3. 获取产品总数据量
        Double sum = baseFileInfoList.stream().mapToDouble(BaseFileInfo::getSize).sum();
        //换算为GB单位
        sum = sum/1000000000;
        DecimalFormat df = new DecimalFormat("##########.##");
//        String.format("%,.2f",num);
        String size = df.format(sum) + " GB";
        StatisticsMainInfo statisticsMainInfo = new StatisticsMainInfo(groupInfoList.size(),count,sum);
        return statisticsMainInfo;
    }

    @Override
    public TodayFileInfo getOneDayFileInfo(Date queueDate) {

        //1.获取当日文件总数
        // 当前系统时间转成UTC时间
        Date UTCNow = TimeUtil.convertToUTC(queueDate);
        Date startTime;
        Date endTime;
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();
        //获得当日最小时刻
        try {
            startTime = TimeUtil.getZero(UTCNow);
            endTime = TimeUtil.getEnd(UTCNow);
            BaseFileInfoExample baseFileInfoExample = new BaseFileInfoExample();
            BaseFileInfoExample.Criteria criteria =  baseFileInfoExample.createCriteria();
            criteria.andForecastTimeBetween(startTime,endTime);
            baseFileInfoList = baseFileInfoMapper.selectByExample(baseFileInfoExample);
            //去掉文件名重复的：因为用户多次上传同一文件，记录每上传1次会增加1条，这里需要去重（去掉文件名同名记录）
            baseFileInfoList = baseFileInfoList.stream().collect(Collectors
                    .collectingAndThen(
                            Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseFileInfo::getFileFullName))),
                            ArrayList::new));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer count = baseFileInfoList.size();
        //2. 获取当日文件总大小
        Double sum = baseFileInfoList.stream().mapToDouble(BaseFileInfo::getSize).sum();
        //换算为GB单位
        sum = sum/1073741824;
        DecimalFormat df = new DecimalFormat("##########.##");
//        String.format("%,.2f",num);
        String size = df.format(sum) + " GB";
        //3. 获取文件类型总数
        List<BaseFileInfo> newBaseFileInfoList = baseFileInfoList.stream().collect(Collectors
                .collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseFileInfo::getForecastType))),
                        ArrayList::new));
        Integer typeNum = newBaseFileInfoList.size();

        return new TodayFileInfo(count,sum,typeNum);
    }

    @Override
    public List<FileInfo> getFileInfo(Integer days) {
        List<FileInfo> fileInfoList = new ArrayList<>();
        //获取当天的相关文件信息
        Date date = new Date();
        //sf为返回结果时的时间格式，此时不需要时分秒
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //queueDateFormat为LOCAL时间和UTC时间转换时的时间格式，此时需要时分秒
        SimpleDateFormat queueDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取前N天的
        for(int index = 0;index < days;index++){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - index);
            Date startDate = calendar.getTime();
            TodayFileInfo todayFileInfo = getOneDayFileInfo(startDate);

            String startDateStr = queueDateFormat.format(startDate);
            Date UTCStartDateStr = TimeUtil.localToUTC(startDateStr);
            String resultDateStr = sf.format(UTCStartDateStr);
//            System.out.println(resultDateStr);
            FileInfo todayFile = new FileInfo(todayFileInfo.getFile_count(),todayFileInfo.getFiles_size(),todayFileInfo.getFile_type_count(),resultDateStr);
            fileInfoList.add(todayFile);
        }
        return fileInfoList;
    }

    @Override
    public List<WatchFileInfo> getWatchList() {

        List<WatchFileInfo> watchFileInfoList = new ArrayList<>();
        SimpleDateFormat sdfutc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        List<BaseFileInfo> baseFileInfoList = getLast12HourFileInfo(null);
        for(BaseFileInfo item : baseFileInfoList){
            //文件大小转换为MB
            BigDecimal b = new BigDecimal(String.valueOf(item.getSize()));
            Double size = b.doubleValue()/1048576;
            //保留2位小数
            String str = String.format("%.2f",size);
            size = Double.parseDouble(str);
//            System.out.println(item.getUpdateTime());
            String utcTime = sdfutc.format(item.getUpdateTime());
//            System.out.println(utcTime);
            watchFileInfoList.add(new WatchFileInfo(item.getFileName(),utcTime,size));

        }
        //4.按照上传时间排序
        Collections.sort(watchFileInfoList, new Comparator<WatchFileInfo>() {
            public int compare(WatchFileInfo arg0, WatchFileInfo arg1) {
                return arg1.getGmt_update().compareTo(arg0.getGmt_update());
            }
        });

        return watchFileInfoList;
    }

    @Override
    public ElementInfo getElementInfo(Integer type, Date date) {
        //1.获取字典表, 后面查询字典不需要再去访问数据库
        DictBaseExample dictBaseExample = new DictBaseExample();
        DictBaseExample.Criteria criteriaDictBase = dictBaseExample.createCriteria();

        ElementInfo elementInfo;

        criteriaDictBase.andCodeEqualTo(type);

        //1.获取全部要素的集合
        List<DictBase> dictBaseList = dictBaseMapper.selectByExample(dictBaseExample);
        if(null == dictBaseList && dictBaseList.size() < 1){
            return null;
        }
        //2.将要素集合封装进返回对象
        DictBase dictBase = dictBaseList.get(0);
        elementInfo =  new ElementInfo(dictBase.getCode(),dictBase.getRemarks());

        //3.查询各个要素的当前完成情况
        //3.1 获取近12H当前要素的文件，去重
        //1.转换为UTC时间

        //2. 获取当前UTC时间前一天的时间作为起始时间
        Date startDate = TimeUtil.getLast12HourTime(date);
        BaseFileInfoExample baseFileInfoExample = new BaseFileInfoExample();
        BaseFileInfoExample.Criteria criteria =  baseFileInfoExample.createCriteria();
        System.out.println(startDate);
        System.out.println(date);
        //降序
        baseFileInfoExample.setOrderByClause("update_time desc");
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();

        //时间在传入时间前24小时的数据
        criteria.andUpdateTimeBetween(startDate,date).andForecastElementEqualTo(type);
        //3.查询符合要求的结果，并封装返回对象
        baseFileInfoList = baseFileInfoMapper.selectByExample(baseFileInfoExample);
        //去掉文件名重复的：因为用户多次上传同一文件，记录每上传1次会增加1条，这里需要去重（去掉文件名同名记录）
        baseFileInfoList = baseFileInfoList.stream().collect(Collectors
                .collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseFileInfo::getFileFullName))),
                        ArrayList::new));

        //4 获取当前要素的总数
        Integer sum;
            //TODO:[-] 这里暂时写死了
        if(ElementEnum.ICE.getValue().equals(elementInfo.getElement_type())){
                sum = ProductSum.getSumIce();
        }else {
                sum = ProductSum.getSumAll();
        }
        Double rate = baseFileInfoList.size()/(double)sum;
            //保留2位小数
        String str = String.format("%.2f",rate);
        rate = Double.parseDouble(str);
        elementInfo.setRate(rate);


        return elementInfo;
    }

    /**
 *@Description:每个流程中检查文件内要素是否全
 *@Param: [baseFileInfoList]
 *@Return: java.util.List<java.lang.String> 记录缺少的要素
 *@Author: QuYuan
 *@Date: 2022/8/17 11:34
 */
    private List<String> checkElements(List<BaseFileInfo> baseFileInfoList){
        //1. 建立一个缺失要素的列表
        List<String> missElementList = new ArrayList<>();

        if(null != baseFileInfoList){
            Map<Integer,List<BaseFileInfo>> groupByLevelList = baseFileInfoList.stream().collect(Collectors.groupingBy(BaseFileInfo::getForecastElement));
            //2. 使用要素集合判断是否要素全
            ElementCollection elementCollection = new ElementCollection();
            for(ElementEnum e : elementCollection.getElementEnumList()){
                if(null == groupByLevelList.get(Integer.parseInt(e.getValue()))){
                    //将缺失的要素写入list
                    missElementList.add(e.getValue());
                }
            }
        }
        return missElementList;
    }
    /**
     *@Description:根据预报机构的级别，获取对应的流程配置
     *@Param: [pid]
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.middleBean.StepInfo>
     *@Author: QuYuan
     *@Date: 2022/8/17 9:34
     */
    private List<StepInfo> getStepByPid(Integer pid){
        ProcessFactory processFactory;
        if(pid.equals(0)){
            //1 一级预报机构（国家级）
            processFactory = new NationalProcessFactory();
        }else if (pid.equals(1001)){
            //2 二级预报机构（海区级）
            processFactory = new RegionalProcessFactory();
        }else {
            //3 三级预报机构（省级）
            processFactory = new ProvinceProcessFactory();
        }
        Process process = processFactory.Manufacture();
        List<StepInfo> stepInfo = process.init();
        return stepInfo;
    }

    /**
     *@Description:根据预报机构的级别，获取对应的流程的文件级别（L1-L5）
     *@Param: [pid]
     *@Return: java.lang.String[]
     *@Author: QuYuan
     *@Date: 2022/8/17 15:18
     */
    private String[] getLevelByPid(Integer pid){
        ProcessFactory processFactory;
        if(pid.equals(0)){
            //1 一级预报机构（国家级）
            processFactory = new NationalProcessFactory();
        }else if (pid.equals(1001)){
            //2 二级预报机构（海区级）
            processFactory = new RegionalProcessFactory();
        }else {
            //3 三级预报机构（省级）
            processFactory = new ProvinceProcessFactory();
        }
        return processFactory.Manufacture().getLevel_list();
    }

    /**
     *@Description:获取最近12个小时的文件信息，并去重
     *@Param: []
     *@Return: java.util.List<com.nmefc.grid_monitor_service.bean.BaseFileInfo>
     *@Author: QuYuan
     *@Date: 2022/8/31 9:26
     */
    private List<BaseFileInfo> getLast12HourFileInfo(@Nullable Date targetDate){
        Date date = new Date();
        if (null != targetDate){
            date = targetDate;
        }
        //1.转换为UTC时间

        Date UTCnow = TimeUtil.convertToUTC(date);
        //2. 获取当前UTC时间前一天的时间作为起始时间
        Date startDate = TimeUtil.getLast12HourTime(UTCnow);
        BaseFileInfoExample baseFileInfoExample = new BaseFileInfoExample();
        BaseFileInfoExample.Criteria criteria =  baseFileInfoExample.createCriteria();
//        System.out.println(startDate);
//        System.out.println(UTCnow);
        //降序
        baseFileInfoExample.setOrderByClause("update_time desc");
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();

        //时间在传入时间前24小时的数据
        criteria.andUpdateTimeBetween(startDate,UTCnow);
        //3.查询符合要求的结果，并封装返回对象
        baseFileInfoList = baseFileInfoMapper.selectByExample(baseFileInfoExample);
        //去掉文件名重复的：因为用户多次上传同一文件，记录每上传1次会增加1条，这里需要去重（去掉文件名同名记录）
        baseFileInfoList = baseFileInfoList.stream().collect(Collectors
                .collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseFileInfo::getFileFullName))),
                        ArrayList::new));
        return baseFileInfoList;
    }

}
