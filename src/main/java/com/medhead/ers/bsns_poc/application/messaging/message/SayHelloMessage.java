package com.medhead.ers.bsns_poc.application.messaging.message;

import com.medhead.ers.bsns_poc.application.messaging.event.AvailableEvent;
import org.json.JSONObject;

public class SayHelloMessage extends Message{

    public SayHelloMessage(String userName) {
        this.eventType = AvailableEvent.SayHello;
        this.setMetadata(
                new JSONObject().put("userName", userName).toMap()
        );
    }
}
