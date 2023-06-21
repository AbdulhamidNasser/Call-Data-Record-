package com.codeline.Call.Data.Record.Repository;

import com.codeline.Call.Data.Record.Model.Cdrs;
import com.codeline.Call.Data.Record.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
}
