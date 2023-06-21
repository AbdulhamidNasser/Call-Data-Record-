package com.codeline.Call.Data.Record.Repository;

import com.codeline.Call.Data.Record.Model.Cdrs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdrsRepository extends JpaRepository<Cdrs,Long> {
}
