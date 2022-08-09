package com.nmefc.grid_monitor_service.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }
}
