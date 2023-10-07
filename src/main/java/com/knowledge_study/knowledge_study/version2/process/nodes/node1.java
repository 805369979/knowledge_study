package com.knowledge_study.knowledge_study.version2.process.nodes;

import com.knowledge_study.knowledge_study.version2.entity.Contant;
import com.knowledge_study.knowledge_study.version2.entity.Context;
import com.knowledge_study.knowledge_study.version2.process.AbstractedProcess;
import org.springframework.stereotype.Component;

/**
 * 任务节点1，doTask方法必须实现
 */
@Component(value = Contant.COUPONS1)
public class node1 extends AbstractedProcess<Context> {

    @Override
    public void doTask(Context data) {
        System.out.println("优惠1----执行");
    }

}
