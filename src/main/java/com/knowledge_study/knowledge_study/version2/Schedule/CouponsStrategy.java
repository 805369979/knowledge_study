package com.knowledge_study.knowledge_study.version2.Schedule;

import com.knowledge_study.knowledge_study.version2.entity.Context;
import com.knowledge_study.knowledge_study.version2.process.AbstractedProcess;
import com.knowledge_study.knowledge_study.version2.util.SpringContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 可插拔策略平台，负责任务的调度
 */
@Component
public class CouponsStrategy {

    @Value("${coupons.items}")
    String[] sortedNodes = new String[]{};

    public void run(Context context) {
        if (CollectionUtils.isEmpty(context.getProcessOrder()) && sortedNodes.length == 0) {
            throw new RuntimeException("优惠顺序需要指定");
        }
        List<String> processOrder = context.getProcessOrder().size()>0? context.getProcessOrder()
                : Arrays.asList(sortedNodes);
        for (String order:processOrder) {
            AbstractedProcess<Context> bean = SpringContext.getBean(order);
            bean.run(context);
        }
    }

}
