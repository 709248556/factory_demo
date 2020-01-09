package com.example.factory_demo;

import com.example.factory_demo.distributor.HelloDistributorFactoryService;
import com.example.factory_demo.factory.helloDistributorServiceImpl;
import com.example.factory_demo.factory.HelloType;
import com.example.factory_demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class FactoryDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(FactoryDemoApplication.class, args);
	}

}
