package com.coedify.sep.backend.NotificationService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="email_definition")
@Entity
public class EmailDefinitionEntity extends BaseEntity{
    @Column(name = "emailGroupId")
    private Long emailGroupId;
    @Column(name = "emailName")
    private String emailName;
    @Column(name = "isHtmlEmail")
    private Boolean htmlEmail;
    @Column(name = "subjectLine")
    private String subjectLine;
    @Column(name = "emailContent")
    private String emailContent;
    @Column(name = "fromAddress")
    private String fromAddress;
    @Column(name = "fromName")
    private String fromName;
    @Column(name = "CCAddress")
    private String CCAddress;
    @Column(name = "BCCAddress")
    private String BCCAddress;
    @Column(name = "ReplyToName")
    private String replyToName;
    @Column(name = "ReplyToAddress")
    private String replyToAddress;

    private Boolean obsolete;
}
