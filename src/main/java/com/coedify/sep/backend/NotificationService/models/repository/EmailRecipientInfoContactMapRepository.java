package com.coedify.sep.backend.NotificationService.models.repository;

import java.util.List;

import com.coedify.sep.backend.NotificationService.models.entity.EmailRecipientInfoContactMapEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRecipientInfoContactMapRepository
        extends JpaRepository<EmailRecipientInfoContactMapEntity, Long> {
    List<EmailRecipientInfoContactMapEntity> findByEmailRecipientInfoId(Long id);//change method name
    // @Query(value = "select contact_id from email_recipient_info_contact_map where
    // email_recipient_info_id=:id", nativeQuery = true)
    // List<Long> findAllContactsId(Long id);
    // boolean findByrecepinetId(Long id);
    // @Query(value = "delete from email_recipient_info_contact_map where email_recipient_info_id =id;", nativeQuery = true)
    //  List<Long> deleteOldContacts(Long id);
    boolean existsByEmailRecipientInfoId(long id);
    void deleteByEmailRecipientInfoId(Long id);
}
