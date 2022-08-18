package com.nmefc.grid_monitor_service.bean.resultBean;

public class GroupInfo {
    private Integer group_code;

    public GroupInfo(Integer group_code, String group_name) {
        this.group_code = group_code;
        this.group_name = group_name;
    }

    public Integer getGroup_code() {
        return group_code;
    }

    public void setGroup_code(Integer group_code) {
        this.group_code = group_code;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    private String group_name;
}
