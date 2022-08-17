package com.nmefc.grid_monitor_service.bean.middleBean;

import com.nmefc.grid_monitor_service.common.ProcessEnum;

import java.util.ArrayList;
import java.util.List;

public class NationalProcessFactory extends ProcessFactory{

    @Override
    public Process Manufacture() {
        return new NationalProcess();
    }
}
