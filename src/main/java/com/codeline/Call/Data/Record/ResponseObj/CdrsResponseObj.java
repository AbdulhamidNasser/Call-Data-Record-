package com.codeline.Call.Data.Record.ResponseObj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CdrsResponseObj {
    String callerNumber;
    String receiverNumber;
    int duration;
    String timestamp;
}
