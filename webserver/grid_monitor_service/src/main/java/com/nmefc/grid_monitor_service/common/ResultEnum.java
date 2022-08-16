package com.nmefc.grid_monitor_service.common;

public enum ResultEnum {
    SUCCESS("Success"),
    NO_CHANGE("NoChanges"),
    UNKNOW_PROBLEM("UnknownProblem"),
    FAILURE("Failure"),
    PARAM_INVALID("Parameter invalid");

    private String value;
    public String getValue(){
        return value;
    }
    ResultEnum(String value) {
        this.value = value;
    }
}
