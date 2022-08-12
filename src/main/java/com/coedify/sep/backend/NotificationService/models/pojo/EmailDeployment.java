package com.coedify.sep.backend.NotificationService.models.pojo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDeployment extends Base {
  @NotBlank
  @Size(min = 10, message = "name should have at least 2 characters")
  private String name;
  @NotBlank
  @Size(min = 10, message = "description should have at least 10 characters")
  private String description;
  @NotNull(message = "emailDefinitionId should not be null") 
  private Long emailDefinitionId;
   @NotNull
  private Integer status;
  @NotNull
  @Min(value=1)
  @Max(value=3)
  private Long priority;
  @NotNull
  // @Pattern(regexp = "^true|false$", message = "this field allowed input is only
  // true or false")
  private Boolean htmlEmail;
  @NotNull(message = "senderContactId should not be null") // validation on service it must be present in contact
  private Long senderContactId;
  // @NotNull
  // @Pattern(regexp = "^true|false$", message = "Is Obsolete field allowed input:
  // true or false")
  private Boolean obsolete;
  private Long totalSent;
  private long totalFailed;
  private Date startDate;
  private Date finishDate;
  @Future
  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  private Date scheduleDate;
  // @NotNull
  // @Pattern(regexp = "^true|false$", message = "batch allowed input is true or
  // false")
  private Boolean batch;
  @NotNull
  private List<Long> recipientGroupId;
  private Set<Long> validSet;
  private List<Long> inValidList;
  // private List<EmailRecipientInfoResponse> result;

}
