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
@Table(name = "emailDeployement_recipientInfo_map_entity")
public class EmailDeployementRecipientInfoMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Long emailDeploymentId;
    private Long emailRecipientInfoId;

    public EmailDeployementRecipientInfoMapEntity(Long emailDeploymentId, Long emailRecipientInfoId) {
        this.emailDeploymentId = emailDeploymentId;
        this.emailRecipientInfoId = emailRecipientInfoId;
    }

    // public boolean exstByObsolete() {
    //     return false;
    // }

    // public boolean existsByObsolete() {
    //     return false;
    // }
}
