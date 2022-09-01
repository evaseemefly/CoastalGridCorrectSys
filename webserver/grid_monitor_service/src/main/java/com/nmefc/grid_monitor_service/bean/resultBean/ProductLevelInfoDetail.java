package com.nmefc.grid_monitor_service.bean.resultBean;

import java.util.List;

public class ProductLevelInfoDetail {
    private Integer index;
    private Integer product_type;

    public void setGroup_list(List<GroupInfoDetail> group_list) {
        this.group_list = group_list;
    }

    private List<GroupInfoDetail> group_list;

    public Integer getIndex() {
        return index;
    }

    public Integer getProduct_type() {
        return product_type;
    }

    public List<GroupInfoDetail> getGroup_list() {
        return group_list;
    }

    public ProductLevelInfoDetail(Integer index, Integer product_type) {
        this.index = index;
        this.product_type = product_type;
    }

}
