package com.coedify.sep.backend.NotificationService.models.repository;

import java.util.List;

import com.coedify.sep.backend.NotificationService.models.entity.EmailDeployementRecipientInfoMapEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDeployementRecipientInfoMapRepositoty extends JpaRepository<EmailDeployementRecipientInfoMapEntity,Long>{
    List<EmailDeployementRecipientInfoMapEntity> findByEmailDeploymentId(Long id);

    boolean existsByEmailDeploymentId(long id);

   
}
