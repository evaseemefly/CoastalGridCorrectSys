package com.nmefc.grid_monitor_service.common;

import java.util.List;

public enum  ElementEnum {
    SSW("5001"),
    WAV("5002"),
    OCU("5003"),
    SST("5004"),
    ICE("5005");


    private String value;
    public String getValue(){
        return value;
    }
    ElementEnum(String value) {
        this.value = value;
    }
}
