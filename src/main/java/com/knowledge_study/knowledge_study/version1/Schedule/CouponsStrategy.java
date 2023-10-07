//package com.knowledge_study.knowledge_study.version1.Schedule;
//
//import com.knowledge_study.knowledge_study.version1.entity.Context;
//import com.knowledge_study.knowledge_study.version1.process.AbstractedProcess;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 可插拔策略平台，负责任务的调度
// */
//@Component
//public class CouponsStrategy {
//    // 此处注意泛型需要自己指定，我用的是Context
//    @Autowired
//    List<AbstractedProcess<Context>> nodes;
//
//    public void run(Context context) {
//        if (CollectionUtils.isEmpty(context.getProcessOrder())) {
//            throw new RuntimeException("优惠顺序需要指定");
//        }
//        List<String> processOrder = context.getProcessOrder();
//        for (String order:processOrder) {
//            List<AbstractedProcess<Context>> curOrderNode = nodes.stream()
//                    .filter(node -> node.getClass().getAnnotation(Component.class).value()
//                            .equals(order)).collect(Collectors.toList());
//            if (!CollectionUtils.isEmpty(curOrderNode)){
//                curOrderNode.get(0).run(context);
//            }
//        }
//    }
//
//}
