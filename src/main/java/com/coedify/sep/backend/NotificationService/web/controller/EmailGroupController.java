package com.coedify.sep.backend.NotificationService.web.controller;

import javax.validation.Valid;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailGroupRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailGroupResponse;
import com.coedify.sep.backend.NotificationService.services.EmailGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailGroupController extends BaseController{
    @Autowired 
    private EmailGroupService emailGroupService;
    @PostMapping("emailgroup")
    public EmailGroupResponse createEmailGroup(@RequestBody @Valid EmailGroupRequest request)
    {
       return emailGroupService.createEmailGroup(request); 
    }
    @GetMapping("/emailgroup/{id}")
    public EmailGroupResponse findEmailGroup(@PathVariable Long id)
    {
        return emailGroupService.findEmailGroup(id);
    }
    
}
