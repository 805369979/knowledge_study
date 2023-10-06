package com.knowledge_study.knowledge_study.process;

import org.springframework.stereotype.Component;

@Component
public class node2 extends AbstractedProcess{

    @Override
    public void doTask(Object data) {
        System.out.println("优惠2----执行");
    }
    
}
