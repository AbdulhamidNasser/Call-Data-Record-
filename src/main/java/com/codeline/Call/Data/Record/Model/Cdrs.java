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
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String callerNumber;
    public String receiverNumber;
    public int duration;
    public String timestamp;
    public Integer month;
    public Integer year;


}
