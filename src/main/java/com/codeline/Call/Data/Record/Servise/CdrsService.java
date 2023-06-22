package com.codeline.Call.Data.Record.Servise;

import com.codeline.Call.Data.Record.Model.Cdrs;
import com.codeline.Call.Data.Record.Repository.CdrsRepository;
import com.codeline.Call.Data.Record.ResponseObj.CdrsResponseObj;
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


}
