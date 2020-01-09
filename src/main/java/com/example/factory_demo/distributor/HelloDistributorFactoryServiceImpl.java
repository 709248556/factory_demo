package com.example.factory_demo.distributor;

import com.example.factory_demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanlianglong
 * @Title: HelloDistributorFactoryServiceImpl.java
 * @Package com.example.factory_demo.distributor
 * @Description:
 * @date 2020/1/9 15:54
 */
@Service("helloDistributorFactoryService")
public class HelloDistributorFactoryServiceImpl implements HelloDistributorFactoryService {

    @Autowired
    private HelloDistributorService helloDistributorService;

    @Override
    public String sayHello(String type) throws Exception{
        String result = "";
        HelloService converter = helloDistributorService.getConverter(type);
        if(converter != null){
            result = converter.sayHello();
        }else {
            throw new Exception("HelloDistributorFactoryServiceImpl.getConverter 失败，未配置到相关分发器{" + type + "}");
        }
        return result;
    }
}
