package com.nmefc.grid_monitor_service.bean.resultBean;

public class FileInfo extends TodayFileInfo{
    private String dt;
    public FileInfo(String file_count, String files_size, String file_type_count, String dt) {
        super(file_count, files_size, file_type_count);
        this.dt = dt;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}
