package com.ywl.study;

import com.ywl.study.service.IDemoService;
import com.ywl.study.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource({"classpath*:dubbo-consumer.xml"})
@RestController
public class DubboRongcuoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRongcuoConsumerApplication.class, args);
    }

    @Autowired
    IDemoService demoService;
    @Autowired
    @Qualifier(value = "demoService2")
    IDemoService demoService2;

    @Autowired
    IHelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        return demoService.methodInvoke();
    }

    @RequestMapping("/getValue")
    public String getValue(){
        return demoService.getValue();
    }
    @RequestMapping("/getValue2")
    public String getValueRedirect(){
        return demoService2.getValue();
    }

    @RequestMapping("/myHello")
    public String myHello(){
        return helloService.myHello();
    }
}
