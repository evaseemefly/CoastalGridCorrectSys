package com.nmefc.grid_monitor_service.bean.middleBean;

import com.nmefc.grid_monitor_service.common.ElementEnum;

import java.util.ArrayList;
import java.util.List;
/**
 *@Description: 预报要素的集合（最全要素）
 *@Param:
 *@Return:
 *@Author: QuYuan
 *@Date: 2022/8/17 11:32
 */
public class ElementCollection {
    private List<ElementEnum> elementEnumList = new ArrayList<>();

    public ElementCollection() {
        this.elementEnumList.add(ElementEnum.ICE);
        this.elementEnumList.add(ElementEnum.WAV);
        this.elementEnumList.add(ElementEnum.SST);
        this.elementEnumList.add(ElementEnum.SSW);
        this.elementEnumList.add(ElementEnum.OCU);
    }

    public List<ElementEnum> getElementEnumList() {
        return elementEnumList;
    }
}
