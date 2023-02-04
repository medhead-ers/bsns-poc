package com.medhead.ers.bsns_poc.domain.exception;

import java.util.UUID;

public class PatientNotFoundException extends  RuntimeException{
    public PatientNotFoundException(UUID uuid) {
        super("Could not find patient " + uuid);
    }
}
