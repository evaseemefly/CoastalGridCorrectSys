package com.nmefc.grid_monitor_service.common;

public enum  TimeEnum {
    AM("20"),
    PM("08"),
    NIGHT("");
    private String value;
    public String getValue(){
        return value;
    }
    TimeEnum(String value) {
        this.value = value;
    }
}
