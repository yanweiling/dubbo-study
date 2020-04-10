package com.ywl.study;

import com.ywl.study.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource({"classpath*:dubbo-consumer.xml"})
@RestController
public class DubboStartcheckConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboStartcheckConsumerApplication.class, args);
    }

    @Autowired
    IDemoService demoServiceConsumer;
    @RequestMapping("/getValue")
    public int getValue(){
        return demoServiceConsumer.multi(1,2);
    }
}
