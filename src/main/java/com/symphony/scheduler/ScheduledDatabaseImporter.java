package com.symphony.scheduler;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledDatabaseImporter {

    @Scheduled(fixedRate = 60 * 1000)
    @Timed(description = "Timed spend for DB importing")
    public void importDBData() throws InterruptedException {
        log.info("Starting scheduled DB import");
        fetchDataFromDB();
        log.info("Scheduled DB importing has finished");
    }

    private void fetchDataFromDB() throws InterruptedException {
        Thread.sleep(3_000);
    }
}
