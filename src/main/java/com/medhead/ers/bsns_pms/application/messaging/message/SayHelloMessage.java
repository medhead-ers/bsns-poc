package com.medhead.ers.bsns_pms.application.messaging.message;

import com.medhead.ers.bsns_pms.application.messaging.event.AvailableEvent;
import org.json.JSONObject;

public class SayHelloMessage extends Message{

    public SayHelloMessage(String userName) {
        this.eventType = AvailableEvent.SayHello;
        this.setMetadata(
                new JSONObject().put("userName", userName).toMap()
        );
    }
}
