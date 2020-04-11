package com.ywl.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ywl.study.service.CallbackListener;
import com.ywl.study.service.IDemoSerivce2;
import com.ywl.study.service.entity.Computer;
import com.ywl.study.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/callback")
@RestController
public class CallbackController {
    @Autowired
    IDemoSerivce2 demoServiceCall;

    @RequestMapping("/getUserDetail")
    public String getUserDetail(){
        User user=demoServiceCall.getUserDetail("test", new CallbackListener() {
            @Override
            public Computer assignComputer() {
                Computer computer=new Computer();
                computer.setId(2);
                computer.setName("华硕笔记本");
                return computer;
            }

            @Override
            public void change(String s, double v) {

            }
        });
        return JSON.toJSONString(user);
    }

    @RequestMapping("/export")
    public void export() throws InterruptedException {
        demoServiceCall.exportData("导入数据", new CallbackListener() {
            @Override
            public Computer assignComputer() {
                return null;
            }

            @Override
            public void change(String s, double v) {
                System.out.println("任务:"+s+",执行进度:"+v+"%");
            }
        });
        Thread.sleep(1000*20);
    }

}
