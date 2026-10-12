package com.example.demoLogstash;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventGenerator implements CommandLineRunner {

    static final Logger log =
            LoggerFactory.getLogger(EventGenerator.class);

    @Override
    public void run(String... args) throws Exception {



        String[] events = {
                "Container Loaded",
                "QC Job Started",
                "Container Validation Failed",
                "Container Released",
                "QC Job Completed"
        };

        int index = 0;

        while (true) {

            String event = events[index];

            if(event.contains("Failed")) {
                log.error(event);
            } else {
                log.info(event);
            }

            index = (index + 1) % events.length;

            Thread.sleep(5000);
        }
    }
}
