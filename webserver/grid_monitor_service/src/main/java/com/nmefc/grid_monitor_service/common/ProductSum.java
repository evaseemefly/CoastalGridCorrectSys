package com.nmefc.grid_monitor_service.common;

import java.util.HashMap;
import java.util.Map;

public class ProductSum {
    //1. 海面风，海浪，海流，海温，每次预报的每个要素的产品总数
    private final static Integer SUM_ALL = 1*3 + 3*2 + 16;
    //2. 海冰每次预报的产品总数（只有北海区做）
    private final static Integer SUM_ICE = 1*3 + 1*2 + 6;

    public static Map<Integer, Integer> getLevelSumMap() {
        levelSumMap.put(Integer.parseInt(ProcessEnum.L0.getValue()), SUM_L0);
        levelSumMap.put(Integer.parseInt(ProcessEnum.L1.getValue()), SUM_L1);
        levelSumMap.put(Integer.parseInt(ProcessEnum.L2.getValue()), SUM_L2);
        levelSumMap.put(Integer.parseInt(ProcessEnum.L3.getValue()), SUM_L3);
        levelSumMap.put(Integer.parseInt(ProcessEnum.L4.getValue()), SUM_L4);
        levelSumMap.put(Integer.parseInt(ProcessEnum.L5.getValue()), SUM_L5);
        return levelSumMap;
    }

    //TODO:[-]没有海冰暂时
    private static Map<Integer, Integer> levelSumMap = new HashMap<>();
    private final static Integer SUM_L0 = 4*1;
    private final static Integer SUM_L1 = 4*16;
    private final static Integer SUM_L2 = 4*3;
    private final static Integer SUM_L3 = 4*3;
    private final static Integer SUM_L4 = 4*1;
    private final static Integer SUM_L5 = 4*1;
    //TODO:[-]这样设计不好后期优化
    public final static String ICE = "ICE";
    public static Integer getSumAll() {
        return SUM_ALL;
    }

    public static Integer getSumIce() {
        return SUM_ICE;
    }
}
