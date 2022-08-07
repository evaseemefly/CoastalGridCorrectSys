package com.nmefc.grid_monitor_service.mapper;


import com.nmefc.grid_monitor_service.bean.UserBean;

public interface UserMapper {

    UserBean getInfo(String name, String password);

}