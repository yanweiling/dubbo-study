package com.ywl.study.service.impl;


import com.alibaba.dubbo.rpc.RpcContext;
import com.ywl.study.service.IDemoService;
import org.springframework.stereotype.Service;

@Service("demoService1")
public class DemoService_v1 implements IDemoService {

    public int sum(Integer x, Integer y) {
        // TODO Auto-generated method stub
        try{
            Thread.sleep(3000);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return x + y;
    }

    public int multi(Integer x, Integer y) {
        // TODO Auto-generated method stub
        try{
            Thread.sleep(5000);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return x * y;
    }
/*RpcContext可以隐式传参*/
    public String methodInvoke() {
        String index=RpcContext.getContext().getAttachment("index");
        return "new-"+index;
    }

}
