package com.nmefc.grid_monitor_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nmefc.grid_monitor_service.mapper")
public class GridMonitorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GridMonitorServiceApplication.class, args);
	}

}
