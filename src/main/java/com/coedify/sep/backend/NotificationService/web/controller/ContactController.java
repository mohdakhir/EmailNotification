package com.coedify.sep.backend.NotificationService.web.controller;
import com.coedify.sep.backend.NotificationService.models.dto.request.ContactRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactResponse;
import com.coedify.sep.backend.NotificationService.services.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ContactController extends BaseController{
    @Autowired
    private ContactServiceImpl contactserviceImpl;
    @PostMapping("/contact")
    ContactResponse saveContact(@RequestBody  ContactRequest request) {
        return contactserviceImpl.saveContact(request);
    }
}
