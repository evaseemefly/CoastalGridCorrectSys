package com.nmefc.grid_monitor_service;


import com.nmefc.grid_monitor_service.bean.UserBean;
import com.nmefc.grid_monitor_service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.nmefc.grid_monitor_service.mapper")
public class TestApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        UserBean userBean = userService.loginIn("a","123");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getId());
    }

}
