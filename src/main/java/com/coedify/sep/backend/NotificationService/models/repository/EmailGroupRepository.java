package com.coedify.sep.backend.NotificationService.models.repository;

import com.coedify.sep.backend.NotificationService.models.entity.EmailGroupEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailGroupRepository extends JpaRepository<EmailGroupEntity,Long>{
    
}
