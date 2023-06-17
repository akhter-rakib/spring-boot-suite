package com.rakib.springreactive.dao;

import com.rakib.springreactive.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

@Component
@Slf4j
public class CustomerDao {

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCustomers() {
        return IntStream.range(1, 10)
                .peek(CustomerDao::sleepExecution)
                .peek(value -> System.out.println("processing count" + value))
                .mapToObj(i -> new Customer(i, "cusomer " + i))
                .toList();
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(value -> log.info("processing count in Stream " + value))
                .map(i -> new Customer(i, "cusomer " + i));
    }
}
