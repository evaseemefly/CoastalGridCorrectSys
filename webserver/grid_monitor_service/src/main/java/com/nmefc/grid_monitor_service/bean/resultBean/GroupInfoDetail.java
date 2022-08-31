package com.nmefc.grid_monitor_service.bean.resultBean;

public class GroupInfoDetail extends GroupInfo {
    public GroupInfoDetail(Integer group_code, String group_name,  Integer pid, Integer sort) {
        super(group_code, group_name);
        this.pid = pid;
        this.sort = sort;
    }


    private Integer pid;
    private Integer sort;
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
