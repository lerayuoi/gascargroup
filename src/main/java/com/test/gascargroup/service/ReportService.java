package com.test.gascargroup.service;

import com.test.gascargroup.dto.ReportDto;
import com.test.gascargroup.entity.Report;
import com.test.gascargroup.entity.Speaker;
import com.test.gascargroup.exception.EntityNotFoundException;
import com.test.gascargroup.repository.ReportRepository;
import com.test.gascargroup.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements ReportServiceBean {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private SpeakerRepository speakerRepository;

    @Override
    public Report createReport(ReportDto reportDto) {
        Report report = new Report(reportDto.getName(), reportDto.getDate());
        if (reportDto.getSpeakerId() != null){
            Speaker speaker = speakerRepository.getOne(reportDto.getSpeakerId());
            report.setSpeaker(speaker);
        }
        return reportRepository.save(report);
    }

    @Override
    public Report getReportById(Long id) {
        this.findReport(id);
        return reportRepository.getOne(id);
    }

    @Override
    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    @Override
    public Report updateReport(Long id, ReportDto report) {
        Report updatedReport = this.findReport(id);

        updatedReport.setDate(report.getDate() != null ? report.getDate() : updatedReport.getDate());
        updatedReport.setName(report.getName() != null ? report.getName() : updatedReport.getName());

        if (report.getSpeakerId() != null) {
            Speaker speaker = speakerRepository.getOne(report.getSpeakerId());
            updatedReport.setSpeaker(speaker);
        }

        return reportRepository.save(updatedReport);
    }

    @Override
    public void deleteReport(Long id) {
        this.findReport(id);
        reportRepository.deleteById(id);
    }

    private Report findReport(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Report " + id + " does not exist!"));
    }
}
