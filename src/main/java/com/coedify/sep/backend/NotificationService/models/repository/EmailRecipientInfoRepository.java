package com.coedify.sep.backend.NotificationService.models.repository;

import com.coedify.sep.backend.NotificationService.models.entity.EmailRecipientInfoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRecipientInfoRepository extends JpaRepository<EmailRecipientInfoEntity,Long> {
    
}
