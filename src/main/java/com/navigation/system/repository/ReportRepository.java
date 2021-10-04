package com.navigation.system.repository;

import com.navigation.system.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "SELECT * FROM REPORTS", nativeQuery = true)
    List<Report> fetchAllReport();
}
