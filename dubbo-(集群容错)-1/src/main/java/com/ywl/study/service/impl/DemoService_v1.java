package com.ywl.study.service.impl;

import com.ywl.study.service.IDemoService;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoService_v1 implements IDemoService {

	public int sum(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	public int multi(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	public String methodInvoke() {
		// TODO Auto-generated method stub
		return "node-A";
	}

	public String getValue(){
		return "node-A-getValue";
	}

}
