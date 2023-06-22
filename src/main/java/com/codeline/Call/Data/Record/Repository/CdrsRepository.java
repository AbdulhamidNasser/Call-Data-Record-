package com.codeline.Call.Data.Record.Repository;

import com.codeline.Call.Data.Record.Model.Cdrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CdrsRepository extends JpaRepository<Cdrs,Long> {
    List<Cdrs> findByCallerNumberAndTimestampBetween(String callerNumber, String timestampFrom, String timestampTo);

    List<Cdrs> findByUsername(String username);


}
