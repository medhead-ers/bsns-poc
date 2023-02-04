package com.medhead.ers.bsns_poc.application.messaging.job;

import com.medhead.ers.bsns_poc.application.messaging.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SayHelloJob extends Job{
    private final String userName;

    private static final Logger LOGGER = LoggerFactory.getLogger(SayHelloJob.class);
    public SayHelloJob(Event event) {
        super(event);
        this.userName = event.getMetadata().get("userName");
    }

    public void process() throws Exception {
        if (userName == null){
            throw new Exception("Username Cannot be null to be processed");
        }
        LOGGER.info("Hello " + userName);
    }

}
