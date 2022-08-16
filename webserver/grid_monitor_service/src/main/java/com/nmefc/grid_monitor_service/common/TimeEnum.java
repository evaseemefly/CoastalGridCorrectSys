package com.nmefc.grid_monitor_service.common;

public enum  TimeEnum {
    AM("08"),
    PM("20"),
    NIGHT("");
    private String value;
    public String getValue(){
        return value;
    }
    TimeEnum(String value) {
        this.value = value;
    }
}
