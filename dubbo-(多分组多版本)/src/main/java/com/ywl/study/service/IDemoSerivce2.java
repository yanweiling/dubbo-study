package com.ywl.study.service;

import com.ywl.study.service.entity.Computer;
import com.ywl.study.service.entity.User;

public interface IDemoSerivce2 {
    public User getUserDetail(String value, CallbackListener callbackListener);

    public void exportData(String taskName,CallbackListener callbackListener);
}
