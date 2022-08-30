package com.nmefc.grid_monitor_service.bean.resultBean;

import java.util.Date;

public class WatchFileInfo {
    private String file_name;
    private String gmt_update;
    private Double size;

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getGmt_update() {
        return gmt_update;
    }

    public void setGmt_update(String gmt_update) {
        this.gmt_update = gmt_update;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public WatchFileInfo(String file_name, String gmt_update, Double size) {
        this.file_name = file_name;
        this.gmt_update = gmt_update;
        this.size = size;
    }
}
