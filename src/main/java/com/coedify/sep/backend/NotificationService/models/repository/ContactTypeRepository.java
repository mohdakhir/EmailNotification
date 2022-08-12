package com.coedify.sep.backend.NotificationService.models.repository;

import com.coedify.sep.backend.NotificationService.models.entity.ContactTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactTypeRepository extends JpaRepository<ContactTypeEntity,Long>{
    
}
