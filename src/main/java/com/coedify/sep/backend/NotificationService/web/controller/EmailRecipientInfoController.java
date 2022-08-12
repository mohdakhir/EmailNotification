package com.coedify.sep.backend.NotificationService.web.controller;

import javax.validation.Valid;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailRecipientInfoRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailRecipientInfoResponse;
import com.coedify.sep.backend.NotificationService.services.EmailRecipientInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement
@RestController
public class EmailRecipientInfoController extends BaseController {
    @Autowired
    private EmailRecipientInfoService emailRecipientInfoService;
    @PostMapping("/emailrecipientinfo")
    public EmailRecipientInfoResponse createRecipientInfo(@RequestBody @Valid EmailRecipientInfoRequest request) {
        return emailRecipientInfoService.createRecipientInfo(request);
    }

    @GetMapping("/emailrecipientinfo/{id}")
    public EmailRecipientInfoResponse getRecipientInfo(@PathVariable Long id) {
        return emailRecipientInfoService.getRecipientInfo(id);
    }

    @PostMapping("/newlyAddedContacts/{id}") 
    public EmailRecipientInfoResponse addToContactList(@PathVariable Long id,
            @RequestBody EmailRecipientInfoRequest request) {
        return emailRecipientInfoService.addToContactList(id, request);
    }

    @DeleteMapping("emailrecipientInfo")
    public String deleteRecipientInfo(@RequestBody EmailRecipientInfoRequest request) {
        return emailRecipientInfoService.deleteRecipientInfo(request);
    }
    @PutMapping("emailrecipientInfo/{id}")
    public EmailRecipientInfoResponse updateDeployment(@PathVariable Long id,@RequestBody EmailRecipientInfoRequest request) 
     {
        return emailRecipientInfoService.updateEmailDeployemntById(id,request);
     } 
}
