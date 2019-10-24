package com.symphony.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class HelloController {

    private static final AtomicLong HELLO_COUNTER = new AtomicLong(0);
    private static final AtomicLong GOODBYE_COUNTER = new AtomicLong(0);

    @RequestMapping("/hello")
    public String sayHello() {
        long counter = HELLO_COUNTER.getAndIncrement();
        log.info("Calling hello service {} times.", counter);

        return "Hello: " + counter;
    }

    @RequestMapping("/goodbye")
    public String sayGoodbye() {
        long counter = GOODBYE_COUNTER.getAndIncrement();
        log.info("Calling goodbye service {} times.", counter);

        return "Goodbye: " + counter;
    }
}
