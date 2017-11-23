package com.example.demo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.node.NodeValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
public class ElasticSearchConfig {

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clustername;

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusternodes;
    @Bean
    public TransportClient getTransprotClient(){
        try{
            TransportClientFactoryBean transportClientFactoryBean = new TransportClientFactoryBean();
            transportClientFactoryBean.setClusterName(clustername);
            transportClientFactoryBean.setClusterNodes(clusternodes);
            transportClientFactoryBean.setClientTransportSniff(false);
            transportClientFactoryBean.afterPropertiesSet();
            return transportClientFactoryBean.getObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws NodeValidationException {
        return new ElasticsearchTemplate(getTransprotClient());
    }

}
