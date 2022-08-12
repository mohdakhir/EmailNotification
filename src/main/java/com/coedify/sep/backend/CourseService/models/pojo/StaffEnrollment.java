package com.coedify.sep.backend.CourseService.models.pojo;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StaffEnrollment extends Base {
    
    private Long courseId;

    private Long staffId;

    //@CreationTimestamp
    private Instant startDate;

    private Instant tentativeEndDate;

    private Instant extendedDate;

    private Instant completionDate;
}
