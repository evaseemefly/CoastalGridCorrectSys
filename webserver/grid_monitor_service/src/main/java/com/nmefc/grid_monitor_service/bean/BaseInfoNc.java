package com.nmefc.grid_monitor_service.bean;

import java.util.Date;

public class BaseInfoNc {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte isDelete;

    private Integer typeId;

    private Integer districtId;

    private Date fcstTime;

    private Date updateTime;

    private Integer level;

    private Integer valid;

    private Integer timeResolved;

    private String fileName;

    private String extension;

    private Integer size;

    private String path;

    private Byte isStandard;

    private Integer caseState;

    private Integer tid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Date getFcstTime() {
        return fcstTime;
    }

    public void setFcstTime(Date fcstTime) {
        this.fcstTime = fcstTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getTimeResolved() {
        return timeResolved;
    }

    public void setTimeResolved(Integer timeResolved) {
        this.timeResolved = timeResolved;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Byte getIsStandard() {
        return isStandard;
    }

    public void setIsStandard(Byte isStandard) {
        this.isStandard = isStandard;
    }

    public Integer getCaseState() {
        return caseState;
    }

    public void setCaseState(Integer caseState) {
        this.caseState = caseState;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}