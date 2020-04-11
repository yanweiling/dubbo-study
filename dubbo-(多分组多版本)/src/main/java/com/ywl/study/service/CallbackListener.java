package com.ywl.study.service;

import com.ywl.study.service.entity.Computer;
import com.ywl.study.service.entity.User;

import java.io.Serializable;

public interface CallbackListener extends Serializable {
    //分配电脑，具体分配操作由消费端完成
    public Computer assignComputer();

    //操作进度变更
    void change(String message,double progress);
}
