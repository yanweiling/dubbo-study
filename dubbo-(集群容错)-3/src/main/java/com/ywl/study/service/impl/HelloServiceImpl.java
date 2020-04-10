package com.ywl.study.service.impl;

import com.ywl.study.service.IHelloService;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String myHello() {
        return "myHello-C";
    }

}
