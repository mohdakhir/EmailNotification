package com.coedify.sep.backend.CourseService.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.commons.converter.TopicConverter;
import com.coedify.sep.backend.CourseService.models.entity.ModuleTopicEntity;
import com.coedify.sep.backend.CourseService.models.entity.TopicEntity;
import com.coedify.sep.backend.CourseService.models.pojo.ModuleTopic;
import com.coedify.sep.backend.CourseService.models.repository.ModuleTopicRepository;
import com.coedify.sep.backend.CourseService.models.repository.TopicRepository;
import com.coedify.sep.backend.CourseService.services.ModuleTopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ModuleTopicServiceImpl implements ModuleTopicService {

    @Autowired
    ModuleTopicRepository moduleTopicRepository;

    @Autowired
    TopicRepository topicRepository;

    @Override
    public List<?> createModuleStructure(ModuleTopic moduleTopicRequest) {
        List<ModuleTopicEntity> entity = new ArrayList<>();
        AtomicInteger orderCount = new AtomicInteger(1);
       
        moduleTopicRequest.getTopicId().forEach(value -> {

            try{
                
                if (topicRepository.existsById(value)) {

                    ModuleTopicEntity mTopicEntity = new ModuleTopicEntity();
    
                    mTopicEntity.setTopicId(value);
                    mTopicEntity.setModuleId(moduleTopicRequest.getModuleId());
                    mTopicEntity.setTopicOrder(orderCount.get());
                    entity.add(mTopicEntity);
                    orderCount.incrementAndGet();
                }else{
                    log.error("Topic Id does not exist", value);
                    throw new Exception("Topic Id "+value+" does not exists");
                }

            }catch(Exception e){
                e.printStackTrace();
            }      

        });

        return moduleTopicRepository.saveAll(entity);
    }

    @Override
    @Transactional
    public void deleteModuleStructure(Long moduleId) {
        moduleTopicRepository.deleteByModuleId(moduleId);
    }

    @Override
    @Transactional
    public List<?> updateModuleStructure(ModuleTopic moduleTopicRequest) {
        deleteModuleStructure(moduleTopicRequest.getModuleId());
        return createModuleStructure(moduleTopicRequest);
    }

    @Override
    @Transactional
    public void deleteModuleStructureByTopicId(Long topicId) {
        moduleTopicRepository.deleteByTopicId(topicId);
    }

}
