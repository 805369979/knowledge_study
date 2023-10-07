package com.knowledge_study.knowledge_study.version2.controller;

import com.knowledge_study.knowledge_study.version2.Schedule.CouponsStrategy;
import com.knowledge_study.knowledge_study.version2.entity.Contant;
import com.knowledge_study.knowledge_study.version2.entity.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class TestProcess {
    @Autowired
    CouponsStrategy couponsStrategy;
    @GetMapping("/process")
    public void process(){
        System.out.println(Contant.COUPONS1);
        // 初始化可插拔模块上下文
        Context context = new Context();
        // 可插拔顺序自行指定
        couponsStrategy.run(context);
    }
    @GetMapping("/process1")
    public void process1(){
        // 初始化可插拔模块上下文
        Context context = new Context();
        // 可插拔顺序自行指定
        List<String> objects = new ArrayList<>();
        // 指定可插拔模块顺序
        context.setProcessOrder(objects);
        couponsStrategy.run(context);
    }
}
