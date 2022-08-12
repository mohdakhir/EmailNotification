package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.QualificationEntity;
import com.coedify.sep.backend.CourseService.models.pojo.QualificationDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface QualificationRespository extends JpaRepository<QualificationEntity, Long> {

  List<QualificationEntity> getAllByStaffId(@Param("sid") Long staffId);

  void deleteByStaffId(@Param("sid") Long staffId);

  @Query(value = "select q.id as id,qt.qualification_type as type, qc.qualification_course as qualificationCourse, ub.university_board as universityBoard, q.cgpa as cgpa, q.start_date as startDate, q.end_Date as endDate from qualification q LEFT JOIN university_board ub ON q.university_board = ub.id LEFT JOIN qualification_type qt ON q.qualification_type_Id = qt.id LEFT JOIN qualification_course qc ON q.qualification_course_id = qc.id", nativeQuery = true)
  List<QualificationDetails> getQualificationDetails();

}
