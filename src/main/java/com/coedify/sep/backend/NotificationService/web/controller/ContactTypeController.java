package com.coedify.sep.backend.NotificationService.web.controller;

import javax.validation.Valid;

import com.coedify.sep.backend.NotificationService.models.dto.request.ContactTypeRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactTypeResponse;
import com.coedify.sep.backend.NotificationService.services.ContactTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactTypeController extends BaseController{
    @Autowired
    private ContactTypeService contactTypeService;
    @PostMapping("/contacttype")
    public ContactTypeResponse createContactType(@RequestBody @Valid ContactTypeRequest request)
    {
        return contactTypeService.createContactType(request);
    }
    @GetMapping("/contacttype/{id}")
    public ContactTypeResponse findContactType(@PathVariable Long id)
    {
        return contactTypeService.findContactType(id);
    }
    @DeleteMapping("/contacttype/{id}")
    public String deleteContactType(@PathVariable Long id)
    {
        return contactTypeService.deleteContactType(id);
    }
    @PutMapping("/contacttype/{id}")
    public ContactTypeResponse updateContactType(@RequestBody @Valid ContactTypeRequest request,@PathVariable Long id)
    {
        return contactTypeService.updateContactType(id,request);
    }

}
