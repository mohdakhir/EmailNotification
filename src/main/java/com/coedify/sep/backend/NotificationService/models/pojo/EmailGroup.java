package com.coedify.sep.backend.NotificationService.models.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailGroup extends Base{
    @NotBlank
    @Size(min=2,message="name length should require at least two characters")//should be unique?
    private String name;
    @NotBlank
    @Size(min = 10, message = "description should have at least 10 characters")
    private String description;
    private Boolean obsolete;
}
