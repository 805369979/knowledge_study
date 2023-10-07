package com.knowledge_study.knowledge_study.version1.process;

/**
 * 可插拔抽象节点
 * @param <T>
 */
public abstract class AbstractedProcess<T> implements ProcessInterface<T> {

    @Override
    public void checkParam(T data) {}


    /**
     * 节点任务收尾工作，回收资源，存储数据库等
     * @param data
     */
    @Override
    public void doLast(T data) {}

    /**
     * 节点门面调度入口
     * @param data
     */
    public void run(T data) {
        checkParam(data);
        doTask(data);
        doLast(data);
    }
}
