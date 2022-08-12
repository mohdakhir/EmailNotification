package com.coedify.sep.backend.CourseService.services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.models.entity.CourseModuleEntity;
import com.coedify.sep.backend.CourseService.models.pojo.CourseModule;
import com.coedify.sep.backend.CourseService.models.repository.CourseModuleRepository;
import com.coedify.sep.backend.CourseService.models.repository.ModuleRepository;
import com.coedify.sep.backend.CourseService.services.CourseModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseModuleServiceImpl implements CourseModuleService {

    @Autowired
    CourseModuleRepository courseModuleRepository;
    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public List<?> saveCourseModule(CourseModule request) {

        List<CourseModuleEntity> courseModuleList = new LinkedList<>();
        AtomicInteger orderCount = new AtomicInteger(1);
        request.getModuleIds().forEach(value -> {

            try {
                if (moduleRepository.existsById(value)) {
                    CourseModuleEntity cmEntity = new CourseModuleEntity();
                    cmEntity.setCourseId(request.getCourseId());
                    cmEntity.setModuleId(value);
                    cmEntity.setModuleOrder(orderCount.get());

                    courseModuleList.add(cmEntity);
                    orderCount.incrementAndGet();
                }else{
                    log.error("Module id does not exist",value);
                    throw new Exception("Module Id "+value+" not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        log.info("Saving Course with corresponding modules and topics");
        return courseModuleRepository.saveAll(courseModuleList);
    }

    @Override
    @Transactional
    public void deleteCourseStructure(Long courseId) {
        log.info("delete course structure by Course ID", courseId);
        courseModuleRepository.deleteByCourseId(courseId);
    }

    @Override
    @Transactional
    public List<?> updateCourseStructure(CourseModule request) {
        deleteCourseStructure(request.getCourseId());
        log.info("update course structure of course with courseId",request.getCourseId());
        return saveCourseModule(request);
    }

    @Override
    @Transactional
    public void deleteCourseStructureByModuleId(Long moduleId) {
        log.info("delete course structure by module Id", moduleId);
        courseModuleRepository.deleteByModuleId(moduleId);
    }

}
