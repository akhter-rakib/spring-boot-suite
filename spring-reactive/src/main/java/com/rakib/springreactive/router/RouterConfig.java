package com.rakib.springreactive.router;

import com.rakib.springreactive.handler.CustomerHandler;
import com.rakib.springreactive.handler.CustomerStreamHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    private final CustomerHandler customerHandler;
    private final CustomerStreamHandler customerStreamHandler;

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/router/customers/", customerHandler::loadCustomer)
                .GET("/router/customers/{id}", customerHandler::getCustomer)
                .POST("/router/customers/save-customer", customerHandler::saveCustomer)
                .GET("/router/stream/customers/", customerStreamHandler::getCustomer)
                .build();
    }
}
