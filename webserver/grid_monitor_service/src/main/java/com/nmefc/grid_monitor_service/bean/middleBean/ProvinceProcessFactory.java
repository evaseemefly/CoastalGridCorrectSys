package com.nmefc.grid_monitor_service.bean.middleBean;

public class ProvinceProcessFactory extends ProcessFactory {
    @Override
    public Process Manufacture() {
        return new ProvinceProcess();
    }
}
