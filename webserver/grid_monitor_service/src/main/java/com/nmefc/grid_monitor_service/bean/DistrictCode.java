package com.nmefc.grid_monitor_service.bean;

import java.util.Date;

public class DistrictCode {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte isDelete;

    private String agentCode;

    private String agentChineseName;

    private String fcstDistrictArea;

    private String fcstDistrictChineseName;

    private Integer pid;

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

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getAgentChineseName() {
        return agentChineseName;
    }

    public void setAgentChineseName(String agentChineseName) {
        this.agentChineseName = agentChineseName == null ? null : agentChineseName.trim();
    }

    public String getFcstDistrictArea() {
        return fcstDistrictArea;
    }

    public void setFcstDistrictArea(String fcstDistrictArea) {
        this.fcstDistrictArea = fcstDistrictArea == null ? null : fcstDistrictArea.trim();
    }

    public String getFcstDistrictChineseName() {
        return fcstDistrictChineseName;
    }

    public void setFcstDistrictChineseName(String fcstDistrictChineseName) {
        this.fcstDistrictChineseName = fcstDistrictChineseName == null ? null : fcstDistrictChineseName.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}