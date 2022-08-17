package com.nmefc.grid_monitor_service.bean.middleBean;

import com.nmefc.grid_monitor_service.common.ProcessEnum;

import java.util.ArrayList;
import java.util.List;
/**
 *@Description:国家级预报机构的流程
 *@Param:
 *@Return:
 *@Author: QuYuan
 *@Date: 2022/8/17 8:38
 */
public class NationalProcess implements Process {
    private List<StepInfo> step_list = new ArrayList<>();
    private String[] level_list;


    @Override
    public  List<StepInfo> init(){
        //配置流程，后续流程变更需在此修改
        StepInfo stepInfo1 = new StepInfo(1, ProcessEnum.GUIDE.getValue(),Integer.parseInt(ProcessEnum.FAIL.getValue()));
        this.step_list.add(stepInfo1);
        StepInfo stepInfo2 = new StepInfo(2,ProcessEnum.FUSION.getValue(),Integer.parseInt(ProcessEnum.FAIL.getValue()));
        this.step_list.add(stepInfo2);
        StepInfo stepInfo3 = new StepInfo(3,ProcessEnum.CORRECT.getValue(),Integer.parseInt(ProcessEnum.FAIL.getValue()));
        this.step_list.add(stepInfo3);
        return this.step_list;
    }

    @Override
    public String[] getLevel_list() {
        this.level_list = new String[]{ProcessEnum.L0.getValue(), ProcessEnum.L4.getValue(), ProcessEnum.L5.getValue()};

        return this.level_list;
    }


}
