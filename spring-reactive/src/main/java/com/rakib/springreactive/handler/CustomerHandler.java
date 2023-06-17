package com.rakib.springreactive.handler;

import com.rakib.springreactive.dao.CustomerDao;
import com.rakib.springreactive.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CustomerHandler {

    private final CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomer(ServerRequest serverRequest) {
        Flux<Customer> customers = customerDao.getCustomer();
        return ServerResponse.ok().body(customers, Customer.class);
    }

    public Mono<ServerResponse> getCustomer(ServerRequest serverRequest) {
        int customerId = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Customer> customerFlux = customerDao.getCustomer()
                .filter(customer -> customer.getId() == customerId).next();
        return ServerResponse.ok().body(customerFlux, Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request) {
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> stringMono = customerMono.map(customer -> customer.getId() + " : " + customer.getName());
        return ServerResponse.ok().body(stringMono, String.class);
    }
}
