package com.test.gascargroup.repository;

import com.test.gascargroup.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

//    @Query(nativeQuery = true, value = "SELECT r.id, r.name, r.date, r.speaker_id FROM reports r WHERE r.id = :id")
//    Report getReportById(@Param("id") Long id);
}
