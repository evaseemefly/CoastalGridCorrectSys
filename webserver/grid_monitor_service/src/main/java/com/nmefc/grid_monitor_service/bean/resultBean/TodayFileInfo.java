package com.nmefc.grid_monitor_service.bean.resultBean;

public class TodayFileInfo {
    private Integer file_count;
    private Double files_size;
    private Integer file_type_count;

    public TodayFileInfo(Integer file_count, Double files_size, Integer file_type_count) {
        this.file_count = file_count;
        this.files_size = files_size;
        this.file_type_count = file_type_count;
    }

    public Integer getFile_count() {
        return file_count;
    }

    public void setFile_count(Integer file_count) {
        this.file_count = file_count;
    }

    public Double getFiles_size() {
        return files_size;
    }

    public void setFiles_size(Double files_size) {
        this.files_size = files_size;
    }

    public Integer getFile_type_count() {
        return file_type_count;
    }

    public void setFile_type_count(Integer file_type_count) {
        this.file_type_count = file_type_count;
    }
}
