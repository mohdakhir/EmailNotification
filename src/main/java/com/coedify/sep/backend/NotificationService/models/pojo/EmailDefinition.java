package com.coedify.sep.backend.NotificationService.models.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDefinition extends Base {
    @NotNull(message = "emailGroupId cannot be null")
    private Long emailGroupId;
    @NotBlank(message = "please mention email name")
    private String emailName;
    @NotNull
    private Boolean htmlEmail;
    private String subjectLine;
    @NotBlank(message = "email content cannot be blank")
    private String emailContent;
    @NotBlank
    private String fromAddress;
    @NotBlank
    private String fromName;
    @NotBlank
    private String CCAddress;
    @NotBlank
    private String BCCAddress;
    @NotBlank
    private String replyToName;
    @NotBlank
    private String replyToAddress;
    @NotNull
    private Boolean obsolete;
}
