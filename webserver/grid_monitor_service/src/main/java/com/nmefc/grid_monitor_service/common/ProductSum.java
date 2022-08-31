package com.nmefc.grid_monitor_service.common;

public class ProductSum {
    //1. 海面风，海浪，海流，海温，每次预报的每个要素的产品总数
    private final static Integer SUM_ALL = 1*3 + 3*2 + 16;
    //2. 海冰每次预报的产品总数（只有北海区做）
    private final static Integer SUM_ICE = 1*3 + 1*2 + 6;

    public static Integer getSumAll() {
        return SUM_ALL;
    }

    public static Integer getSumIce() {
        return SUM_ICE;
    }
}
