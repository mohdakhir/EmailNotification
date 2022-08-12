package com.coedify.sep.backend.NotificationService.models.pojo;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactType {
   private Long id;
    @NotBlank
    @Size(min=2,message="contactType should be at least 2 characters")
  private  String contactType;
}
