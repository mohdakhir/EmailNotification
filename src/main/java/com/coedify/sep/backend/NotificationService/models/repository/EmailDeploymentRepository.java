package com.coedify.sep.backend.NotificationService.models.repository;
import com.coedify.sep.backend.NotificationService.models.entity.EmailDeploymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmailDeploymentRepository extends JpaRepository<EmailDeploymentEntity,Long>{

    boolean existsByEmailDefinitionId(Long id);

  //  boolean exsitByEmailDefinition(long id);
    
}
