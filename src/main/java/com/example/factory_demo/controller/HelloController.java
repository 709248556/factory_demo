package com.example.factory_demo.controller;

import com.example.factory_demo.distributor.HelloDistributorFactoryService;
import com.example.factory_demo.factory.HelloType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanlianglong
 * @Title: HelloController.java
 * @Package com.example.factory_demo.controller
 * @Description:
 * @date 2020/1/9 16:09
 */
@RestController
public class HelloController {

    @Autowired
    HelloDistributorFactoryService helloDistributorFactoryService;

    @GetMapping("/sayHello")
    public String sayHello(){
        String result = "";
        try {
            result = helloDistributorFactoryService.sayHello(HelloType.HELLO_YAN.getValue());
        }catch (Exception e){

        }
        return result;
    }
}
