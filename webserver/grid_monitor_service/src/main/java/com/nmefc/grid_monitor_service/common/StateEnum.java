package com.nmefc.grid_monitor_service.common;

public enum  StateEnum {
    SUCCESS("20"),
    PM("08"),
    NIGHT("");
    private String value;
    public String getValue(){
        return value;
    }
    StateEnum(String value) {
        this.value = value;
    }
}
