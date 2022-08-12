package com.coedify.sep.backend.NotificationService.models.repository;

import com.coedify.sep.backend.NotificationService.models.entity.EmailDefinitionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailDefinitionRepository extends JpaRepository<EmailDefinitionEntity,Long>{
    
}
