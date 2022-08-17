package com.nmefc.grid_monitor_service.service.serviceImpl;

import com.nmefc.grid_monitor_service.bean.BaseFileInfo;
import com.nmefc.grid_monitor_service.bean.BaseFileInfoExample;
import com.nmefc.grid_monitor_service.bean.DictBase;
import com.nmefc.grid_monitor_service.bean.DictBaseExample;
import com.nmefc.grid_monitor_service.bean.middleBean.*;
import com.nmefc.grid_monitor_service.bean.middleBean.Process;
import com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProcessInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProductInfo;
import com.nmefc.grid_monitor_service.common.ElementEnum;
import com.nmefc.grid_monitor_service.common.ProcessEnum;
import com.nmefc.grid_monitor_service.mapper.BaseFileInfoMapper;
import com.nmefc.grid_monitor_service.mapper.DictBaseMapper;
import com.nmefc.grid_monitor_service.service.BaseFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    if (item.getIssurerId().equals(dictItem.getCode())){
                        ProductInfo productInfo = new ProductInfo(item.getIssurerId(),dictItem.getRemarks());
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
            System.out.println(startDate);
            System.out.println(date);

            //检索机构ID等于传入的ID，并且时间在传入时间前24小时的数据
            criteria.andIssurerIdEqualTo(code).andForecastTimeBetween(startDate,date);
            try{
                baseFileInfoList = baseFileInfoMapper.selectByExample(baseFileInfoExample);
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

}
