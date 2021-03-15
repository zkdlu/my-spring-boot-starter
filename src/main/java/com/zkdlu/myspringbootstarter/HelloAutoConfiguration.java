package com.zkdlu.myspringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Hello.class)
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {
    @Autowired
    private HelloProperties helloProperties;

    @Bean
    @ConditionalOnMissingBean
    public HelloConfig helloConfig() {
        String userName = helloProperties.getUserName() == null ? System.getProperty("user.name")
                : helloProperties.getUserName();

        HelloConfig helloConfig = new HelloConfig() ;
        helloConfig.put("user.name", userName);

        return helloConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Hello hello(HelloConfig helloConfig) {
        return new Hello(helloConfig);
    }
}
