package com.navigation.system.repository;

import com.navigation.system.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportsRepository extends JpaRepository<Reports, Long> {
    @Query(value = "SELECT * FROM REPORTS", nativeQuery = true)
    List<Reports> fetchAllReports();
}
