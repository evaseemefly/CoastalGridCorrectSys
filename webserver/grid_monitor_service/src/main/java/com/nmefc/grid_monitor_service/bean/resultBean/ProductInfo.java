package com.nmefc.grid_monitor_service.bean.resultBean;

public class ProductInfo {
    public ProductInfo(Integer product_code, String product_name) {
        this.product_code = product_code;
        this.product_name = product_name;
    }

    private Integer product_code;
    private String product_name;

    public Integer getProduct_code() {
        return product_code;
    }

    public void setProduct_code(Integer product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
