package com.nmefc.grid_monitor_service.bean.middleBean;

public class RegionalProcessFactory extends ProcessFactory {
    @Override
    public Process Manufacture() {
        return new RegionalProcess();
    }
}
