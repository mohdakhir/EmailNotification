package com.coedify.sep.backend.NotificationService.models.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDeployementRecipientInfoMap {
    private Long emailDeploymentId;
    private Long emailRecipientInfoId;

}
