package com.medhead.ers.bsns_poc.application.controller;

import com.medhead.ers.bsns_poc.application.messaging.exception.MessagePublicationFailException;
import com.medhead.ers.bsns_poc.application.messaging.message.factory.MessageFactory;
import com.medhead.ers.bsns_poc.application.messaging.service.definition.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMessagingController {
    @Autowired
    private MessagePublisher messagePublisher;

    @PostMapping("/rest-messaging/say-hello")
    public String sayHello(@RequestParam("userName") String userName) throws MessagePublicationFailException {
        messagePublisher.publish(MessageFactory.createSayHelloMessage(userName));
        return "Your message has been sent";
    }
}
