package com.test.gascargroup.controller;

import com.test.gascargroup.dto.ReportDto;
import com.test.gascargroup.entity.Report;
import com.test.gascargroup.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/report")
public class ReportController {
    @Autowired
    private ReportService service;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Report> createReport(@Valid @RequestBody final ReportDto reportDto) {
        Report newReport = service.createReport(reportDto);
        return new ResponseEntity<>(newReport, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Report> getReportById(@PathVariable final Long id) {
        Report report = service.getReportById(id);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Report>> getReports() {
        List<Report> list = service.getReports();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<Report> updateReport(@PathVariable final Long id, @Valid @RequestBody final ReportDto reportDto) {
        Report updatedReport = service.updateReport(id, reportDto);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<HttpStatus> deleteReport(@PathVariable final Long id) {
        service.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
