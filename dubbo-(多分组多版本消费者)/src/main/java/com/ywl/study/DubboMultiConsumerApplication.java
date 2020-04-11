package com.ywl.study;

import com.alibaba.dubbo.rpc.RpcContext;
import com.ywl.study.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@SpringBootApplication
@ImportResource({"classpath*:dubbo-consumer.xml"})
@RestController
public class DubboMultiConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboMultiConsumerApplication.class, args);
    }

    @Autowired
    IDemoService demoServiceFirst;
    @Autowired
    IDemoService demoServiceSecond;
//    @Autowired
//    IDemoService demoServiceThird;

    @Autowired
    IDemoService demoServiceDownLevel;

    @RequestMapping("/hello1")
    public String hello(){
        RpcContext.getContext().setAttachment("index","i love you");
        return demoServiceFirst.methodInvoke();
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return demoServiceSecond.methodInvoke();
    }

//    @RequestMapping("/hello3")
//    public String hello3(){
//        return demoServiceThird.methodInvoke();

    @RequestMapping("/asyn")
    public String asyn() throws Exception{
        long start=System.currentTimeMillis();
        demoServiceFirst.sum(1, 2);
        Future<Integer> sumRes = RpcContext.getContext().getFuture();
        demoServiceFirst.multi(12, 13);
        Future<Integer> multiRes = RpcContext.getContext().getFuture();
        StringBuffer sb=new StringBuffer();
        sb.append("sum:"+sumRes.get()+",multi:"+multiRes.get());
        long end=System.currentTimeMillis();
        String result="总共耗时："+(end-start)/1000+"秒";
        return sb.append(result).toString();
    }
    /*接口超时，服务提供者则会什么也不返回，所以配置降级服务*/
    @RequestMapping("/downLevel")
    public int downLevel(){
        return demoServiceDownLevel.sum(1,5);
    }


}
