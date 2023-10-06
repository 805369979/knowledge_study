package com.knowledge_study.knowledge_study.process;

import org.springframework.stereotype.Component;

@Component
public class node1 extends AbstractedProcess{

    @Override
    public void doTask(Object data) {
        System.out.println("优惠1----执行");
    }

}
