package com.example.demo.service;

import com.example.demo.model.IndexBaseObject;

public interface ESearchService {
    void SingleInsert(String serviceAlias, IndexBaseObject indexBaseObject,String esIndex);
    void SingleUpdate(String serviceAlias, IndexBaseObject indexBaseObject, String esIndex);
    void SingleDelate(String serviceAlias, String esIndex);
}