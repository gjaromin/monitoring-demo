package com.symphony.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class HelloController {

    //traditional way
    private static final AtomicLong HELLO_COUNTER = new AtomicLong(0);
    private static final AtomicLong GOODBYE_COUNTER = new AtomicLong(0);


    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        long counter = HELLO_COUNTER.getAndIncrement();
        log.info("Calling hello service {} times.", counter);

        Metrics.counter("custom.metrics.hello").increment();


        return String.format("Hello: %s. Total number of calls: %d", name, counter);
    }

    @Timed(value = "Time spend on longHello method", longTask = true, histogram = true)
    @RequestMapping("/longHello")
    public String sayLongHello() throws InterruptedException {
        log.info("calling sayLongHello, going to sleep");
        Thread.sleep((long) (Math.random() * 10 * 1000));
        log.info("wake up from sayLongHello");

        Metrics.counter("custom.metrics.long.hello").increment();


        return "Long Hello";
    }

    @RequestMapping("/goodbye")
    public String sayGoodbye() {
        long counter = GOODBYE_COUNTER.getAndIncrement();
        log.info("Calling goodbye service {} times.", counter);

        Metrics.counter("custom.metrics.goodbye").increment();

        return "Goodbye: " + counter;
    }
}
