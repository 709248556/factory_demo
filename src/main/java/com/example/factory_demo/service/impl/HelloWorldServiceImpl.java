package com.example.factory_demo.service.impl;

import com.example.factory_demo.factory.HelloAnnotation;
import com.example.factory_demo.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@HelloAnnotation("HELLO_WORLD")
public class HelloWorldServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "Hello World";
    }
}
