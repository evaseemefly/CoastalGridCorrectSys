package com.nmefc.grid_monitor_service.service.serviceImpl;


import com.nmefc.grid_monitor_service.bean.UserBean;
import com.nmefc.grid_monitor_service.mapper.UserMapper;
import com.nmefc.grid_monitor_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }
}