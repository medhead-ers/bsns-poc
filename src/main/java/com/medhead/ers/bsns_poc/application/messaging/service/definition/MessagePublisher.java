package com.medhead.ers.bsns_poc.application.messaging.service.definition;

import com.medhead.ers.bsns_poc.application.messaging.exception.MessagePublicationFailException;
import com.medhead.ers.bsns_poc.application.messaging.message.Message;

public interface MessagePublisher {
    public void publish(Message message) throws MessagePublicationFailException;
}
