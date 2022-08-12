package com.coedify.sep.backend.NotificationService.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.NotificationService.commons.converter.EmailDeploymentConverter;
import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDeploymentRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDeploymentResponse;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailRecipientInfoResponse;
import com.coedify.sep.backend.NotificationService.models.entity.EmailDeployementRecipientInfoMapEntity;
import com.coedify.sep.backend.NotificationService.models.entity.EmailDeploymentEntity;
import com.coedify.sep.backend.NotificationService.models.repository.EmailDeployementRecipientInfoMapRepositoty;
import com.coedify.sep.backend.NotificationService.models.repository.EmailDeploymentRepository;
import com.coedify.sep.backend.NotificationService.models.repository.EmailRecipientInfoRepository;
import com.coedify.sep.backend.NotificationService.services.EmailDeploymentService;
import com.coedify.sep.backend.NotificationService.services.EmailRecipientInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailDeploymentServiceImpl implements EmailDeploymentService {

    @Autowired
    private EmailDeploymentRepository emaildeploymentrepository;

    @Autowired
    private EmailRecipientInfoRepository recipientRepository;

    @Autowired
    private EmailDeployementRecipientInfoMapRepositoty deployemntRecipientMapRepo;
    @Autowired
    private EmailRecipientInfoService emailRecipientInfoService;

    @Override
    public EmailDeploymentResponse createDeployment(EmailDeploymentRequest request) {
        List<Long> recipients = request.getRecipientGroupId();
        List<EmailDeployementRecipientInfoMapEntity> deploymentRecipientMap = new ArrayList<>();
        EmailDeploymentResponse response = saveEmailDeployment(request);
        Set<Long> validSet = vaidateList(recipients);
        List<Long> inValidList = inVaidateList(recipients);
        validSet.stream().forEach(value -> {
            deploymentRecipientMap
                    .add(new EmailDeployementRecipientInfoMapEntity(response.getId(), value));
        });
        deployemntRecipientMapRepo.saveAll(deploymentRecipientMap);
        response.setValidSet(validSet);
        response.setInValidList(inValidList);
        return response;
    }

    private Set<Long> vaidateList(List<Long> recipients) {
        Set<Long> validSet = new HashSet<>();
        recipients.stream().forEach(recipient -> {
            if (recipientRepository.existsById(recipient)) {
                validSet.add(recipient);
            }
        });
        if (validSet.isEmpty()) {
            throw new AssetNotFoundException("No Valid Contacts");
        }
        return validSet;
    }

    private List<Long> inVaidateList(List<Long> recipients) {
        List<Long> invalidList = new ArrayList<>();
        recipients.stream().forEach(recipient -> {
            if (!recipientRepository.existsById(recipient)) {
                invalidList.add(recipient);
            }
        });
        return invalidList;
    }

    public EmailDeploymentResponse saveEmailDeployment(EmailDeploymentRequest request) {
        return EmailDeploymentConverter
                .entityToResponse(emaildeploymentrepository.save(EmailDeploymentConverter.requestToEntity(request)));
    }

    @Override
    public EmailDeploymentResponse getDeploymentById(Long id) {
        if (!emaildeploymentrepository.existsById(id)) {
            throw new AssetNotFoundException("deployment id does not exist");
        }
        List<Long> recipients = new ArrayList<>();

        EmailDeploymentResponse response = getDeployemnt(id);

        List<EmailRecipientInfoResponse> result = new ArrayList<>();

        List<EmailDeployementRecipientInfoMapEntity> mapEntity = deployemntRecipientMapRepo.findByEmailDeploymentId(id);
        mapEntity.stream().forEach(entity -> {
            recipients.add(entity.getEmailRecipientInfoId());
        });
        recipients.stream().forEach(recepient -> {
            result.add(emailRecipientInfoService.getRecipientInfo(recepient));
        });
        response.setResult(result);
        return response;
    }

    public EmailDeploymentResponse getDeployemnt(Long id) {
        return EmailDeploymentConverter.entityToResponse(emaildeploymentrepository.findById(id).get());
    }

    @Override
    public String deleteDeploymentById(Long id) {
        EmailDeploymentEntity entity = emaildeploymentrepository.findById(id).orElse(null);
        if (!emaildeploymentrepository.existsById(entity.getId())) {
            throw new AssetNotFoundException("deployment id does not exist");
        } else {
            if (emaildeploymentrepository.findById(id).get().getStatus() > 0) {
                throw new AssetNotFoundException("deploment is underprocessing ");
            } else if(deployemntRecipientMapRepo.existsByEmailDeploymentId(id))
            {
                throw new AssetNotFoundException("can not be delete ");
            }
            else {
                entity.setObsolete(true);
                emaildeploymentrepository.save(entity);
                return "successfully logically deleted " + id;
            }//what if deployment id is present in map table
        }
    }
}
// create deployment
// contraint ->definitionid priority check osolete
// physical delete and partial update or fully update is not
// possible might be possible deployment is in progress state
// if deployment is inprogress or sent or failed not possible
// if it has state 0 then only possible