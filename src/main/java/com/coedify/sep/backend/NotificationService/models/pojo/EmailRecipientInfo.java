package com.coedify.sep.backend.NotificationService.models.pojo;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRecipientInfo extends Base {
    @NotBlank
    @Size(min=2,message="name should have at least 2 characters")
    private String name;
    @NotBlank
    @Size(min=10,message="description should have at least 2 characters")
    private String description;
    private Boolean obsolete;
    private List<Long> contactlist;
    private List<Long> inValidList;
    private Set<Long> validSet;
    private List<Long> nonExistedContacts;
    private List<Long> existedContacts;
   private List<Long> deletedContacts;
}
