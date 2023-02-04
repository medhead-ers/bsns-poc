package com.medhead.ers.bsns_poc.application.messaging.exception;

public class MessagePublicationFailException extends Exception {
    public MessagePublicationFailException(Exception exception) {
        super(exception.getMessage());
    }
}
