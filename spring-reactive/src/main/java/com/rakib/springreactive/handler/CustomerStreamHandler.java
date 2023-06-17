package com.rakib.springreactive.handler;

import com.rakib.springreactive.dao.CustomerDao;
import com.rakib.springreactive.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerStreamHandler {

    private final CustomerDao customerDao;

    public Mono<ServerResponse> getCustomer(ServerRequest request) {
        Flux<Customer> customerMono = customerDao.getCustomersStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerMono, Customer.class);
    }

}
