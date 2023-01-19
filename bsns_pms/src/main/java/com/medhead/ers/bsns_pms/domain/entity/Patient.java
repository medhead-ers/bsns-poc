package com.medhead.ers.bsns_pms.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Patient
{
    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName ;
    public Patient(){}

}
