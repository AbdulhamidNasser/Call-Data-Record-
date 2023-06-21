package com.codeline.Call.Data.Record.Repository;

import com.codeline.Call.Data.Record.Model.Analytic;
import com.codeline.Call.Data.Record.Model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {
}
