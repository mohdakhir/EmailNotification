package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.StaffEntity;
import com.coedify.sep.backend.CourseService.models.pojo.StaffAndStaffType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {

    @Query(value = "SELECT s.name as name, s.id as id,s.email as email, s.mobile_number as mobileNumber, st.staff_type as staffType FROM Staff s JOIN staff_type st ON s.staff_type_id =st.id", nativeQuery = true)
    List<StaffAndStaffType> getStaffWithStaffType();

}
