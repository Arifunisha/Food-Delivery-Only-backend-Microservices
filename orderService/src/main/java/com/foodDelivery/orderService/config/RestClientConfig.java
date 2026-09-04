package com.foodDelivery.orderService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient(LoadBalancerClient loadBalancerClient) {

        LoadBalancerInterceptor interceptor =
                new LoadBalancerInterceptor(loadBalancerClient);

        return RestClient.builder()
                .requestInterceptor(interceptor)
                .build();
    }
}