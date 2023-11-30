package com.ttsw.officecore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class OfficeCoreApplication {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(OfficeCoreApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEvent() {
        kafkaTemplate.send("pl.pk.office.email", "Sprawdzam czy działa");
    }

}
