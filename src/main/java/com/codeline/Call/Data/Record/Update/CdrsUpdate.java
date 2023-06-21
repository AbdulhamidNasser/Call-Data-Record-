package com.codeline.Call.Data.Record.Update;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdrsUpdate {


    String callerNumber;
    String receiverNumber;
    int duration;
    String timestamp;
}
