package com.nmefc.grid_monitor_service.bean.resultBean;

import com.nmefc.grid_monitor_service.bean.middleBean.StepInfo;

import java.util.List;

public class ProcessInfo {
    private String group_code;
    private String group_name;
    List<StepInfo> step_list;

    public ProcessInfo(String group_code, String group_name, List<StepInfo> step_list) {
        this.group_code = group_code;
        this.group_name = group_name;
        this.step_list = step_list;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public List<StepInfo> getStep_list() {
        return step_list;
    }

    public void setStep_list(List<StepInfo> step_list) {
        this.step_list = step_list;
    }
}
