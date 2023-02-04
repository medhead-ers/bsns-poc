package com.medhead.ers.bsns_poc.application.messaging.message.factory;

import com.medhead.ers.bsns_poc.application.messaging.message.SayHelloMessage;

public abstract interface MessageFactory {
    static SayHelloMessage createSayHelloMessage(String userName) {
        return new SayHelloMessage(userName);
    }
}
