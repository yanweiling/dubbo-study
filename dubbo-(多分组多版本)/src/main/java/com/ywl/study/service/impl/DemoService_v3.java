package com.ywl.study.service.impl;

import com.ywl.study.service.CallbackListener;
import com.ywl.study.service.IDemoSerivce2;
import com.ywl.study.service.IDemoService;
import com.ywl.study.service.entity.Computer;
import com.ywl.study.service.entity.User;
import org.springframework.stereotype.Service;

@Service("demoServiceCallback")
public class DemoService_v3 implements IDemoSerivce2 {
    @Override
    public User getUserDetail(String value, CallbackListener callbackListener) {
        User user=new User();
        user.setName(value);
        System.out.println("获取消费端分配的电脑信息");
        Computer computer = callbackListener.assignComputer();
        user.setComputer(computer);
        return user;
    }

    @Override
    public void exportData(String taskName, CallbackListener callbackListener) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    callbackListener.change("完成第1步",10);
                    Thread.sleep(3000);
                    callbackListener.change("完成第2步",20);
                    Thread.sleep(1000);
                    callbackListener.change("完成第3步",60);
                    Thread.sleep(2000);
                    callbackListener.change("完成第3步",100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
