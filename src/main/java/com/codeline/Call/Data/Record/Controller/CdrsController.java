package com.codeline.Call.Data.Record.Controller;


import com.codeline.Call.Data.Record.Model.Cdrs;
import com.codeline.Call.Data.Record.RequestObj.CdrsRequestObj;
import com.codeline.Call.Data.Record.ResponseObj.CdrsResponseObj;
import com.codeline.Call.Data.Record.Servise.CdrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}
