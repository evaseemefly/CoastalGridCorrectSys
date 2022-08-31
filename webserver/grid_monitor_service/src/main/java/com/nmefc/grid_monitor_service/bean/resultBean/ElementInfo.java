package com.nmefc.grid_monitor_service.bean.resultBean;

public class ElementInfo {
    private Integer element_type;
    private String element_name;
    private Double rate;

    public Integer getElement_type() {
        return element_type;
    }

    public void setElement_type(Integer element_type) {
        this.element_type = element_type;
    }

    public String getElement_name() {
        return element_name;
    }

    public void setElement_name(String element_name) {
        this.element_name = element_name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public ElementInfo(Integer element_type, String element_name) {
        this.element_type = element_type;
        this.element_name = element_name;

    }

    public ElementInfo(Integer element_type, String element_name, Double rate) {
        this.element_type = element_type;
        this.element_name = element_name;
        this.rate = rate;
    }
}
