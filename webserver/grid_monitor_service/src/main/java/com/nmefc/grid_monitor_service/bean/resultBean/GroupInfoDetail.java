package com.nmefc.grid_monitor_service.bean.resultBean;

import com.nmefc.grid_monitor_service.common.ProcessEnum;

public class GroupInfoDetail extends GroupInfo {
    public GroupInfoDetail(Integer group_code, String group_name,  Integer pid, Integer sort) {
        super(group_code, group_name);
        this.pid = pid;
        this.sort = sort;
        this.step_state = Integer.parseInt(ProcessEnum.FAIL.getValue());
    }


    private Integer pid;
    private Integer sort;

    public void setStep_state(Integer step_state) {
        this.step_state = step_state;
    }

    private Integer step_state;



    public Integer getPid() {
        return pid;
    }

    public Integer getSort() {
        return sort;
    }

    public Integer getStep_state() {
        return step_state;
    }
}
