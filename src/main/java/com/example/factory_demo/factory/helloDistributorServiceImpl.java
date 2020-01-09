package com.example.factory_demo.factory;

import com.example.factory_demo.distributor.HelloDistributorService;
import com.example.factory_demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("helloDistributorService")
public class helloDistributorServiceImpl implements HelloDistributorService,InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(helloDistributorServiceImpl.class);

    private static final Map<String, HelloService> accountInstance = new HashMap<String, HelloService>();

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> map = applicationContext.getBeansWithAnnotation(HelloAnnotation.class);
        logger.info("Bean类：{}", map);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String beanName = entry.getKey();
            Object bean = entry.getValue();
            if (!(bean instanceof HelloService)) {
                continue;
            }

            HelloService helloService = (HelloService) bean;
            HelloAnnotation annotation = applicationContext.findAnnotationOnBean(beanName, HelloAnnotation.class);
            String[] accountTransTypes = annotation.value();

            for (String type : accountTransTypes) {
                logger.info("开始加载Hello类型：[{}]的hello功能", type);
                accountInstance.put(type, helloService);
            }
        }
    }

    // 获取具体的实现类
    @Override
    public HelloService getConverter(String tranType)  {
        HelloService helloService = accountInstance.get(tranType);
        if (helloService == null) {
            throw new IllegalArgumentException();
        }
        return helloService;
    }
}
