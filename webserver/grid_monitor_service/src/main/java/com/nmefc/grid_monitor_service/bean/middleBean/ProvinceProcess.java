package com.nmefc.grid_monitor_service.bean.middleBean;

import com.nmefc.grid_monitor_service.common.ProcessEnum;

import java.util.ArrayList;
import java.util.List;

public class ProvinceProcess implements Process {
    private List<StepInfo> step_list = new ArrayList<>();
    private String[] level_list;


    @Override
    public  List<StepInfo> init(){
        //配置流程，后续流程变更需在此修改

        StepInfo stepInfo1 = new StepInfo(1,ProcessEnum.CORRECT.getValue(),Integer.parseInt(ProcessEnum.FAIL.getValue()));
        this.step_list.add(stepInfo1);
        return this.step_list;
    }

    @Override
    public String[] getLevel_list() {
        this.level_list = new String[]{ProcessEnum.L1.getValue()};
        return this.level_list;
    }

}
