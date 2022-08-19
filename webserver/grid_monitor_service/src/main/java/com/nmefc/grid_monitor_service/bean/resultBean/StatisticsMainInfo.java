package com.nmefc.grid_monitor_service.bean.resultBean;

public class StatisticsMainInfo {
    private String forecast_issurer_count;
    private String forecast_product_count;
    private String forecast_product_size;

    public StatisticsMainInfo(String forecast_issurer_count, String forecast_product_count, String forecast_product_size) {
        this.forecast_issurer_count = forecast_issurer_count;
        this.forecast_product_count = forecast_product_count;
        this.forecast_product_size = forecast_product_size;
    }

    public String getForecast_issurer_count() {
        return forecast_issurer_count;
    }

    public void setForecast_issurer_count(String forecast_issurer_count) {
        this.forecast_issurer_count = forecast_issurer_count;
    }

    public String getForecast_product_count() {
        return forecast_product_count;
    }

    public void setForecast_product_count(String forecast_product_count) {
        this.forecast_product_count = forecast_product_count;
    }

    public String getForecast_product_size() {
        return forecast_product_size;
    }

    public void setForecast_product_size(String forecast_product_size) {
        this.forecast_product_size = forecast_product_size;
    }
}
