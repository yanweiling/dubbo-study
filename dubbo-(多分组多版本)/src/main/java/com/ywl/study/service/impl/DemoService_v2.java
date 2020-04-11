package com.ywl.study.service.impl;


import com.ywl.study.service.IDemoService;
import org.springframework.stereotype.Service;

@Service("demoService2")
public class DemoService_v2 implements IDemoService {

    public int sum(Integer x, Integer y) {
        // TODO Auto-generated method stub
        return x + y;
    }

    public int multi(Integer x, Integer y) {
        // TODO Auto-generated method stub
        return x * y;
    }

    public String methodInvoke() {
        // TODO Auto-generated method stub
        return "old";
    }

}
