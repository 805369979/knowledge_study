package com.knowledge_study.knowledge_study.version2.util;


import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws RuntimeException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return (T) context.getBean(requiredType);
    }

    /**
     * 获取bean
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> requiredType) throws RuntimeException {
        return getContext().getBean(name, requiredType);
    }

    /**
     * 获取有给定注解的bean
     *
     * @param annotationType
     * @return
     * @author 2019-08-16 created by pengqiang.ai
     */
    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        return getContext().getBeansWithAnnotation(annotationType);
    }

    /**
     * 获取顺序bean的列表
     *
     * @param annotationType
     * @param clazz
     * @param <T>
     * @return
     * @author 2019-08-16 created by pengqiang.ai
     */
    public static <T> List<T> getBeanListWithAnnotationAndOrder(Class<? extends Annotation> annotationType, Class<T> clazz) {
        Map<String, Object> beanMap = getBeansWithAnnotation(annotationType);
        List<Object> beanList = new ArrayList<>(beanMap.values());
        List<T> beans = (List<T>) beanList;
        beans.sort((v1, v2) -> {
            Order order1 = AopUtils.getTargetClass(v1).getAnnotation(Order.class);
            Order order2 = AopUtils.getTargetClass(v2).getAnnotation(Order.class);
            Integer o1 = order1 == null ? Integer.MAX_VALUE : order1.value();
            Integer o2 = order2 == null ? Integer.MAX_VALUE : order2.value();
            return o1.compareTo(o2);
        });
        return beans;
    }

    /**
     * 根据对应的 class type 获取对应的 bean列表
     *
     * @param type
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return getContext().getBeansOfType(type);
    }
}
