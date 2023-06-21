package com.codeline.Call.Data.Record.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Data
public class Cdrs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String callerNumber;
    public String receiverNumber;
    public int duration;
    public String timestamp;

}
