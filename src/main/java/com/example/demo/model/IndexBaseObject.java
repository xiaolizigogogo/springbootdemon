package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 *
 */
@Data
public class IndexBaseObject implements Serializable {
    //操作名称
    private String operation;
    //索引库的名称
    private String indexName;
    //应用ID用于识别每个工程的实体类
    private String appName;
    //实体类
    private Object data;
}
