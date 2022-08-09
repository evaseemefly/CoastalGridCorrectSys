package com.nmefc.grid_monitor_service.service;


import com.nmefc.grid_monitor_service.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name, String password);

}