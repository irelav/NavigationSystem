package com.navigation.system.service;

import com.navigation.system.entity.Report;
import com.navigation.system.entity.Reports;
import com.navigation.system.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Reports reports, UUID baseId) {
        List<Reports> reportsList = new ArrayList<>();
        Report report = new Report();
        report.setBaseId(baseId);
        reportsList.add(reports);
        reports.setReport(report);
        report.setReportsList(reportsList);

        return reportRepository.save(report);
    }

    public List<Report> fetchReportList() {
        return reportRepository.findAll();
    }
}
