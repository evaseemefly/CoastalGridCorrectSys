package com.nmefc.grid_monitor_service.bean.resultBean;

public class TodayFileInfo {
    private String file_count;
    private String files_size;
    private String file_type_count;

    public TodayFileInfo(String file_count, String files_size, String file_type_count) {
        this.file_count = file_count;
        this.files_size = files_size;
        this.file_type_count = file_type_count;
    }

    public String getFile_count() {
        return file_count;
    }

    public void setFile_count(String file_count) {
        this.file_count = file_count;
    }

    public String getFiles_size() {
        return files_size;
    }

    public void setFiles_size(String files_size) {
        this.files_size = files_size;
    }

    public String getFile_type_count() {
        return file_type_count;
    }

    public void setFile_type_count(String file_type_count) {
        this.file_type_count = file_type_count;
    }
}
