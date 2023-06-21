package com.codeline.Call.Data.Record.RequestObj;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdrsRequestObj {

    String callerNumber;
    String receiverNumber;
    int duration;
    String timestamp;
}
