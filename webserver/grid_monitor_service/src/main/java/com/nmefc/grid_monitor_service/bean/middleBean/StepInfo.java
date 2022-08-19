package com.nmefc.grid_monitor_service.bean.middleBean;

public class StepInfo {
    private Integer step_index;
    private String step_name;
    private Integer step_state;

    public StepInfo(Integer step_index, String step_name, Integer step_state) {
        this.step_index = step_index;
        this.step_name = step_name;
        this.step_state = step_state;
    }

    public Integer getStep_index() {
        return step_index;
    }

    public void setStep_index(Integer step_index) {
        this.step_index = step_index;
    }

    public String getStep_name() {
        return step_name;
    }

    public void setStep_name(String step_name) {
        this.step_name = step_name;
    }

    public Integer getStep_state() {
        return step_state;
    }

    public void setStep_state(Integer step_state) {
        this.step_state = step_state;
    }
}
