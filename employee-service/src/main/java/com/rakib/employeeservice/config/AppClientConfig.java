package com.rakib.employeeservice.config;

import com.rakib.employeeservice.client.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    public EmployeeService client() {
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient()))
                .build();
        return proxyFactory.createClient(EmployeeService.class);
    }
}
