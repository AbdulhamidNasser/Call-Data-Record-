package com.codeline.Call.Data.Record.Controller;


import com.codeline.Call.Data.Record.Model.Cdrs;
import com.codeline.Call.Data.Record.RequestObj.CdrsRequestObj;
import com.codeline.Call.Data.Record.ResponseObj.CdrsResponseObj;
import com.codeline.Call.Data.Record.ResponseObj.ReportResponseObj;
import com.codeline.Call.Data.Record.Servise.CdrsService;
import com.codeline.Call.Data.Record.Update.CdrsUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CdrsController {

    @Autowired
    CdrsService cdrsService;
    @PostMapping("/api/cdrs")
    public ResponseEntity<Void> uploadUser (@RequestBody CdrsRequestObj cdrsRequestObj) {
        createcdrs(cdrsRequestObj);
        return ResponseEntity.ok().build();

    }

    @RequestMapping("/api/cdrs/{cdrId}")
    public CdrsResponseObj createCdrs (@PathVariable Long cdrId)
    {
        return cdrsService.getCdrsById(cdrId);
    }


    public void createcdrs(CdrsRequestObj cdrsRequestObj){
        Cdrs cdrsObj = new Cdrs();
        cdrsObj.setCallerNumber(cdrsRequestObj.getCallerNumber());
        cdrsObj.setDuration(cdrsRequestObj.getDuration());
        cdrsObj.setTimestamp(cdrsRequestObj.getTimestamp());
        cdrsObj.setReceiverNumber(cdrsRequestObj.getReceiverNumber());
        cdrsService.uploadCdrs(cdrsObj);
    }


    @GetMapping("/api/search")
    ResponseEntity<List<CdrsResponseObj>> searchCDRs(
            @RequestParam("caller_number") String callerNumber,
            @RequestParam("timestamp_from") String timestampFrom,
            @RequestParam("timestamp_to") String timestampTo) {
        List<Cdrs> cdrs = cdrsService.searchCDRs(callerNumber, timestampFrom, timestampTo);
        List<CdrsResponseObj> cdrResponses = convertToCdrResponses(cdrs);
        return ResponseEntity.ok(cdrResponses);
    }

    private List<CdrsResponseObj> convertToCdrResponses(List<Cdrs> cdrs) {
        List<CdrsResponseObj> cdrResponses = new ArrayList<>();
        for (Cdrs cdr : cdrs) {
            cdrResponses.add(new CdrsResponseObj(
                    cdr.getCallerNumber(),
                    cdr.getReceiverNumber(),
                    cdr.getDuration(),
                    cdr.getTimestamp()
            ));
        }
        return cdrResponses;
    }

    @PutMapping("/api/cdrs/{cdrId}")
    public ResponseEntity<String> cdrModification(@PathVariable Long cdrId, @RequestBody CdrsUpdate update) {
        String callerNumber =  update.getCallerNumber();
        String receiverNumber = update.getReceiverNumber();
        int duration = update.getDuration();
        String timestamp = update.getTimestamp();
        cdrsService.cdrupdate(cdrId, callerNumber,receiverNumber,duration,timestamp);
        return ResponseEntity.ok("cdr Modification successfully");
    }

    @GetMapping("/api/reports/user_summary")
    public ResponseEntity<ReportResponseObj> getUserSummaryReport(@RequestParam("username") String username) {
        ReportResponseObj report = cdrsService.getUserSummaryReport(username);
        return ResponseEntity.ok(report);
    }











}
