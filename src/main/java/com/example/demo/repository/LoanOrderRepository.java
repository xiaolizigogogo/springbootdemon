 package com.example.demo.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.entity.LoanOrder;

/**
 * 
 * @author jml
 *
 * 2017年11月2日
 */
public interface LoanOrderRepository extends ElasticsearchRepository<LoanOrder, String> {
}