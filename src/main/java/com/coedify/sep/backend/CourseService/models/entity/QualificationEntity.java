package com.coedify.sep.backend.CourseService.models.entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "qualification")
public class QualificationEntity extends BaseEntity {

  @Column(name = "qualification_type_Id")
  private Long qualificationTypeId;

  @Column(name = "university_board")
  private Long universityBoard;

  @Column(name = "qualification_course_id")
  private Long qualificationCourseId;

  @Column(name = "cgpa")
  private Float cgpa;

  @Column(name = "start_date")
  private Instant startDate;

  @Column(name = "end_date")
  private Instant endDate;

  @Column(name = "staff_id")
  private Long staffId;

}


