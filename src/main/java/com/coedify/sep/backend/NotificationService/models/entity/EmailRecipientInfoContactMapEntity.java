package com.coedify.sep.backend.NotificationService.models.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emailRecipientInfo_contact_map")
public class EmailRecipientInfoContactMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Long emailRecipientInfoId;
    private Long contactId;
    public EmailRecipientInfoContactMapEntity(Long emailRecipientInfoId, Long contactId) {
        this.emailRecipientInfoId = emailRecipientInfoId;
        this.contactId = contactId;
    }
}
