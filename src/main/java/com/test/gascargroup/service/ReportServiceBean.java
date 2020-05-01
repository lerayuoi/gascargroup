package com.test.gascargroup.service;

import com.test.gascargroup.dto.ReportDto;
import com.test.gascargroup.entity.Report;

import java.util.List;

public interface ReportServiceBean {
    Report createReport(ReportDto report);

    Report getReportById(Long id);

    List<Report> getReports();

    Report updateReport(Long id, ReportDto report);

    void deleteReport(Long id);
}
