package com.coedify.sep.backend.NotificationService.models.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="emailDeployment_entity")
@Entity
public class EmailDeploymentEntity extends BaseEntity {
   @Column(name = "name",unique=true)
   private String name;
   @Column(name = "description")
   private String description;
   @Column(name = "emailDefinitionId")
   private Long emailDefinitionId;
   @Column(name="status")
   private Integer status ;
   @Column(name = "isHtmlEmail")
   private Boolean htmlEmail;
   @Column(name = "SenderContactId")
   private Long  senderContactId;
   @Column(name = "isObsolete")
   private Boolean obsolete;
   @Column(name = "totalSent")
   private Long totalSent;
   @Column(name = "totalFailed")
   private long totalFailed;
   @Column(name = "priority")
   private Long priority;
   @Column(name = "StartDate")
   private Date startDate;
   @Column(name = "finishDate")
   private Date finishDate;
   @Column(name = "ScheduleDate")
   private Date scheduleDate;
   @Column(name = "isBatch")
   private Boolean batch;
}
