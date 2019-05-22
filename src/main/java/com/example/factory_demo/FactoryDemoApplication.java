package com.example.factory_demo;

import com.example.factory_demo.factory.HelloFactory;
import com.example.factory_demo.factory.HelloType;
import com.example.factory_demo.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryDemoApplication.class, args);
		HelloService helloInstance = HelloFactory.getInstance(HelloType.HELLO_YAN.getValue());
		helloInstance.sayHello();
	}

}
