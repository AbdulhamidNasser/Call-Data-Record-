package com.codeline.Call.Data.Record.Servise;

import com.codeline.Call.Data.Record.Model.Cdrs;
import com.codeline.Call.Data.Record.Repository.CdrsRepository;
import com.codeline.Call.Data.Record.ResponseObj.CdrsResponseObj;
import com.codeline.Call.Data.Record.ResponseObj.ReportResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CdrsService {

    @Autowired
    CdrsRepository cdrsRepository;

    public void uploadCdrs(Cdrs cdrs) {
        cdrsRepository.save(cdrs);
    }

    public CdrsResponseObj getCdrsById(Long cdrId) {
        Optional<Cdrs> optionalCdrs = cdrsRepository.findById(cdrId);
        if (!optionalCdrs.isEmpty()) {
            Cdrs cdrs = optionalCdrs.get();
            CdrsResponseObj cdrsObj = new CdrsResponseObj(cdrs.getCallerNumber(), cdrs.getReceiverNumber(), cdrs.getDuration(), cdrs.getTimestamp());
            return cdrsObj;
        } else {
            return null;
        }


    }

    public List<Cdrs> searchCDRs(String callerNumber, String timestampFrom, String timestampTo) {
        return cdrsRepository.findByCallerNumberAndTimestampBetween(callerNumber, timestampFrom, timestampTo);
    }


    public void cdrupdate(Long cdeId, String callerNumber, String receiverNumber, int duration, String timestamp) {
        Optional<Cdrs> optionalCdrs = cdrsRepository.findById(cdeId);
        if (optionalCdrs.isPresent()) {
            Cdrs cdrs = optionalCdrs.get();
            cdrs.setCallerNumber(callerNumber);
            cdrs.setReceiverNumber(receiverNumber);
            cdrs.setDuration(duration);
            cdrs.setTimestamp(timestamp);
            cdrsRepository.save(cdrs);
        } else {
            System.out.println("ERROR");
        }
    }

    public ReportResponseObj getUserSummaryReport(String username) {
        List<Cdrs> userCDRs = cdrsRepository.findByUsername(username);
        int totalCalls = userCDRs.size();
        int totalDuration = 0;
        for (Cdrs cdr : userCDRs) {
            totalDuration += cdr.getDuration();
        }
        double averageDuration = totalDuration / (double) totalCalls;

        return new ReportResponseObj(username, totalCalls, totalDuration, averageDuration);
    }



}
