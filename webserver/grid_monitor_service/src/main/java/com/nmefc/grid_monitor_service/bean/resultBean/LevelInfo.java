package com.nmefc.grid_monitor_service.bean.resultBean;

import com.nmefc.grid_monitor_service.common.ProcessEnum;

public class LevelInfo {
    private Integer level;
    private Integer sort;

    public Integer getLevel() {
        return level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setStep_state(Integer step_state) {
        this.step_state = step_state;
    }

    public Integer getStep_state() {
        return step_state;
    }

    private Integer step_state;

    public LevelInfo(Integer level, Integer sort) {
        this.level = level;
        this.sort = sort;
        this.step_state = Integer.parseInt(ProcessEnum.FAIL.getValue());
    }
}
