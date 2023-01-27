package com.medhead.ers.bsns_pms.exception;

public class InvalidPatientAgeException extends Exception {
    public InvalidPatientAgeException(int age) {
        super("A patient should be between 0 and 150 years olds (given age : "+ age +")");
    }
}
