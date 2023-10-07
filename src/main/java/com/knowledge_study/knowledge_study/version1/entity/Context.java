package com.knowledge_study.knowledge_study.version1.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class Context {
    // 指定可插拔顺序
    public List<String> processOrder = new CopyOnWriteArrayList<>();
    // 流程中需要用到的数据
    public Map<String, Object> data = new ConcurrentHashMap<>();
}
