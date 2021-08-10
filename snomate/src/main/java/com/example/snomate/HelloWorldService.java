package com.example.snomate;

import com.example.snomate.model.HelloWorldBean;
import com.example.snomate.repository.HelloWorldBeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    HelloWorldBeanRepository helloWorldBeanRepository;


    public List<HelloWorldBean> testService(){
        HelloWorldBean helloWorldBean = new HelloWorldBean();
        helloWorldBean.setMessage("테스트1");
        helloWorldBeanRepository.save(helloWorldBean);
        return helloWorldBeanRepository.findAll();
    }
}
