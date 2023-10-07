package com.knowledge_study.knowledge_study.version2.process;

/**
 * 可插拔接口功能
 * @param <T>
 */
public interface ProcessInterface<T> {
    void checkParam(T data);

    void doTask(T data);

    void doLast(T data);
}
