package com.codeline.Call.Data.Record.Servise;

import com.codeline.Call.Data.Record.Model.Cdrs;
import com.codeline.Call.Data.Record.Repository.AnalyticRepository;
import com.codeline.Call.Data.Record.Repository.CdrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticService {
    @Autowired
    CdrsRepository cdrsRepository;

    public List<Cdrs> getCdrs() {
        return cdrsRepository.findAll();
    }
}
