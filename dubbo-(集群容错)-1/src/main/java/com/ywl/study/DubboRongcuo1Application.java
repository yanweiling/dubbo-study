package com.ywl.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:dubbo-provider.xml"})
public class DubboRongcuo1Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboRongcuo1Application.class, args);
    }

}
