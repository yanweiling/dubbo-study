package com.ywl.study;

import com.ywl.study.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ImportResource({"classpath*:dubbo-provider.xml"})
@RestController
public class DubboStartcheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboStartcheckApplication.class, args);
    }

    @Autowired
    IDemoService demoService;
    @RequestMapping("/hello")
    public int hello(){
      return demoService.multi(1,2);
    }
}
