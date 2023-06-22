package com.codeline.Call.Data.Record.ResponseObj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponseObj {
    private String username;
    private int totalCalls;
    private int totalDuration;
    private double averageDuration;

}
