package com.nmefc.grid_monitor_service.bean;

import java.util.Date;

public class BaseFileInfo {
    private Integer id;

    private Date gmtCreated;

    private Date gmtModified;

    private Byte isDel;

    private Integer issurerId;

    private Date forecastTime;

    private Date updateTime;

    private Integer productType;

    private Integer forecastType;

    private Integer forecastArea;

    private Integer forecastPeriod;

    private Integer forecastInterval;

    private Integer forecastElement;

    private Integer revisalType;

    private Integer level;

    private String fileName;

    private String fileFullName;

    private String fileExt;

    private Float size;

    private String path;

    private Byte isStandard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public Integer getIssurerId() {
        return issurerId;
    }

    public void setIssurerId(Integer issurerId) {
        this.issurerId = issurerId;
    }

    public Date getForecastTime() {
        return forecastTime;
    }

    public void setForecastTime(Date forecastTime) {
        this.forecastTime = forecastTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getForecastType() {
        return forecastType;
    }

    public void setForecastType(Integer forecastType) {
        this.forecastType = forecastType;
    }

    public Integer getForecastArea() {
        return forecastArea;
    }

    public void setForecastArea(Integer forecastArea) {
        this.forecastArea = forecastArea;
    }

    public Integer getForecastPeriod() {
        return forecastPeriod;
    }

    public void setForecastPeriod(Integer forecastPeriod) {
        this.forecastPeriod = forecastPeriod;
    }

    public Integer getForecastInterval() {
        return forecastInterval;
    }

    public void setForecastInterval(Integer forecastInterval) {
        this.forecastInterval = forecastInterval;
    }

    public Integer getForecastElement() {
        return forecastElement;
    }

    public void setForecastElement(Integer forecastElement) {
        this.forecastElement = forecastElement;
    }

    public Integer getRevisalType() {
        return revisalType;
    }

    public void setRevisalType(Integer revisalType) {
        this.revisalType = revisalType;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileFullName() {
        return fileFullName;
    }

    public void setFileFullName(String fileFullName) {
        this.fileFullName = fileFullName == null ? null : fileFullName.trim();
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
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
}