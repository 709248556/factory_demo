package com.example.factory_demo.distributor;

import com.example.factory_demo.service.HelloService;

/**
 * @author yanlianglong
 * @Title: HelloDistributorService.java
 * @Package com.example.factory_demo.distributor
 * @Description:
 * @date 2020/1/9 15:58
 */
public interface HelloDistributorService {
    HelloService getConverter(String tranType);
}
