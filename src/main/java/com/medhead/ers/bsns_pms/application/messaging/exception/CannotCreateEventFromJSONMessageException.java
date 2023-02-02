package com.medhead.ers.bsns_pms.application.messaging.exception;

public class CannotCreateEventFromJSONMessageException extends Exception{
    public CannotCreateEventFromJSONMessageException(String message, Exception exception) {
        super("MessageListener cannot create Event from malformed JSON String : " + message + ". Cause :" + exception.getMessage());
    }
}
