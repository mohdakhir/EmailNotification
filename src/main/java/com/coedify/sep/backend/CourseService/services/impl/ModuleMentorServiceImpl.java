package com.coedify.sep.backend.CourseService.services.impl;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ModuleMentorRequest;
import com.coedify.sep.backend.CourseService.models.entity.ModuleMentorEntity;
import com.coedify.sep.backend.CourseService.models.repository.ModuleMentorRepository;
import com.coedify.sep.backend.CourseService.services.MolduleMentorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModuleMentorServiceImpl implements MolduleMentorService{
    @Autowired
    ModuleMentorRepository moduleMentorRepository;

    @Override
    public List<?> insertEntity(ModuleMentorRequest request){

     List<ModuleMentorEntity> entity= new LinkedList<>();
     request.getModuleId().forEach(value ->{
         ModuleMentorEntity mEntity=new ModuleMentorEntity();
         mEntity.setModuleId(value);
         mEntity.setMentorId(request.getMentorId());
         entity.add(mEntity);

     });
      return moduleMentorRepository.saveAll(entity);
    }

    @Override
    @Transactional
    public void deleteModule(Long moduleId){
        moduleMentorRepository.deleteAllByModuleId(moduleId);
    }

     @Override
     @Transactional
    public List<?> updateEntity(ModuleMentorRequest request , Long id){
      moduleMentorRepository.deleteAllByMentorId(id);

        return insertEntity(request);
    }
}
