package com.example.demo.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.util.StringUtils;
import com.xxl.job.core.executor.XxlJobExecutor;

/**
 * 
 * @author jml
 *
 */
@Configuration
public class XxlJobConfig {
    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);


    @Value("${spring.platform.task.job.admin.addresses}")
    private String addresses;

    @Value("${spring.platform.task.job.executor.appname}")
    private String appname;

    @Value("${spring.platform.task.job.executor.ip}")
    private String ip;

    @Value("${spring.platform.task.job.executor.port}")
    private int port;

    @Value("${spring.platform.task.job.executor.logpath}")
    private String logpath;

    @Value("${spring.platform.task.job.accessToken}")
    private String accessToken;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> job config init.");
        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
        xxlJobExecutor.setIp(ip);
        if(StringUtils.equals("local", ip)){
        	  xxlJobExecutor.setIp(getHostNameForLiunx());
        }
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAppName(appname);
        xxlJobExecutor.setAdminAddresses(addresses);
        xxlJobExecutor.setLogPath(logpath);
        xxlJobExecutor.setAccessToken(accessToken);
        return xxlJobExecutor;
    }
    public static String getHostNameForLiunx() {  
        try {  
            return (InetAddress.getLocalHost()).getHostName();  
        } catch (UnknownHostException uhe) {  
            String host = uhe.getMessage(); // host = "hostname: hostname"  
            if (host != null) {  
                int colon = host.indexOf(':');  
                if (colon > 0) {  
                    return host.substring(0, colon);  
                }  
            }  
            return "UnknownHost";  
        }  
    }  

}