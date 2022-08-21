package com.nmefc.grid_monitor_service.bean.resultBean;

public class StatisticsMainInfo {
    private Integer forecast_issurer_count;
    private Integer forecast_product_count;
    private Double forecast_product_size;

    public StatisticsMainInfo(Integer forecast_issurer_count, Integer forecast_product_count, Double forecast_product_size) {
        this.forecast_issurer_count = forecast_issurer_count;
        this.forecast_product_count = forecast_product_count;
        this.forecast_product_size = forecast_product_size;
    }

    public Integer getForecast_issurer_count() {
        return forecast_issurer_count;
    }

    public void setForecast_issurer_count(Integer forecast_issurer_count) {
        this.forecast_issurer_count = forecast_issurer_count;
    }

    public Integer getForecast_product_count() {
        return forecast_product_count;
    }

    public void setForecast_product_count(Integer forecast_product_count) {
        this.forecast_product_count = forecast_product_count;
    }

    public Double getForecast_product_size() {
        return forecast_product_size;
    }

    public void setForecast_product_size(Double forecast_product_size) {
        this.forecast_product_size = forecast_product_size;
    }
}
