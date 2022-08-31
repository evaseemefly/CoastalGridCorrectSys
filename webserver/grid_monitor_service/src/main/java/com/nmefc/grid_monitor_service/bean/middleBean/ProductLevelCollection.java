package com.nmefc.grid_monitor_service.bean.middleBean;

import com.nmefc.grid_monitor_service.common.ProcessEnum;

import java.util.ArrayList;
import java.util.List;

public class ProductLevelCollection {

    private List<Integer> elementEnumList = new ArrayList<>();

    public ProductLevelCollection() {
        this.elementEnumList.add(Integer.parseInt(ProcessEnum.L0.getValue()));
        this.elementEnumList.add(Integer.parseInt(ProcessEnum.L1.getValue()));
        this.elementEnumList.add(Integer.parseInt(ProcessEnum.L2.getValue()));
        this.elementEnumList.add(Integer.parseInt(ProcessEnum.L3.getValue()));
        this.elementEnumList.add(Integer.parseInt(ProcessEnum.L4.getValue()));
        this.elementEnumList.add(Integer.parseInt(ProcessEnum.L5.getValue()));
    }

    public List<Integer> getElementEnumList() {
        return elementEnumList;
    }
}
