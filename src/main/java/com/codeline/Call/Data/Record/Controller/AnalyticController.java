package com.codeline.Call.Data.Record.Controller;


import com.codeline.Call.Data.Record.Model.Cdrs;
import com.codeline.Call.Data.Record.Servise.AnalyticService;
import com.codeline.Call.Data.Record.Servise.CdrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnalyticController {
    @Autowired
    AnalyticService analyticService ;

    @RequestMapping("/api/analytics/call_durations")
    public ResponseEntity<Map<String, Object>> getCdrs(){
        List<Cdrs> getCdrs = analyticService.getCdrs();
        Integer totalCalls =0;
        Integer totalDuration = 0;
        for( Cdrs cdrs : getCdrs){
            totalCalls++;
            totalDuration = totalDuration + cdrs.getDuration();
        }
        Double average_duration = (double) (totalDuration/totalCalls);
        Map<String, Object> response = new HashMap<>();
        response.put("average_duration", average_duration);
        response.put("total_calls", totalCalls);

        return ResponseEntity.ok(response);
    }
}
