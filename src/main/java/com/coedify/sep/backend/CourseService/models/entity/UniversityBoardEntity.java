package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="university_board")
public class UniversityBoardEntity extends BaseEntity {
  
  @Column(name="university_board")
  private String universityBoard;

  @Column(name="type")
  private Long type;
}
