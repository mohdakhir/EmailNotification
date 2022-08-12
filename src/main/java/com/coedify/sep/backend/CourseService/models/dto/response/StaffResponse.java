package com.coedify.sep.backend.CourseService.models.dto.response;

import com.coedify.sep.backend.CourseService.models.pojo.Staff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StaffResponse extends Staff {
    
    private StaffTypeResponse staffType;

}
