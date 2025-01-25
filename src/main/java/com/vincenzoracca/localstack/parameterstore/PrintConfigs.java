package com.vincenzoracca.localstack.parameterstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PrintConfigs {

    private static final Logger log = LoggerFactory.getLogger(PrintConfigs.class);

    private final LocalstackProperties localstackProperties;

    public PrintConfigs(LocalstackProperties localstackProperties) {
        this.localstackProperties = localstackProperties;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void printConfigs() {
        log.info("Printing env value from parameter-store: {}", localstackProperties.getEnvValue());
    }
}
