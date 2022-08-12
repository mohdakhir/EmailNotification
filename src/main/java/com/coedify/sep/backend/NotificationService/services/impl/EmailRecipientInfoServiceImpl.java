package com.coedify.sep.backend.NotificationService.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.NotificationService.commons.converter.EmailRecipientInfoConverter;
import com.coedify.sep.backend.NotificationService.models.dto.request.EmailRecipientInfoRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailRecipientInfoResponse;
import com.coedify.sep.backend.NotificationService.models.entity.EmailRecipientInfoContactMapEntity;
import com.coedify.sep.backend.NotificationService.models.entity.EmailRecipientInfoEntity;
import com.coedify.sep.backend.NotificationService.models.repository.ContactRepository;
import com.coedify.sep.backend.NotificationService.models.repository.EmailRecipientInfoContactMapRepository;
import com.coedify.sep.backend.NotificationService.models.repository.EmailRecipientInfoRepository;
import com.coedify.sep.backend.NotificationService.services.EmailRecipientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailRecipientInfoServiceImpl implements EmailRecipientInfoService {

   @Autowired
   private EmailRecipientInfoContactMapRepository emailrecipientInfoContactMapRepository;
   @Autowired
   private ContactRepository contactrepository;
   @Autowired
   private EmailRecipientInfoRepository recipientInfoRepo;

   @Override
   public EmailRecipientInfoResponse createRecipientInfo(EmailRecipientInfoRequest request) {
      HashSet<Long> contactlist = new HashSet<>(request.getContactlist());
      List<Long> inValidList = new ArrayList<>();
      Set<Long> validSet = new HashSet<>();
      EmailRecipientInfoResponse response = new EmailRecipientInfoResponse();
      List<EmailRecipientInfoContactMapEntity> mapEntityList = new ArrayList<>();
      for (Long contact : contactlist) {
         if (contactrepository.existsById(contact)) {
            validSet.add(contact);
         } else {
            inValidList.add(contact);
         }
      }
      if (validSet.isEmpty()) {
         throw new AssetNotFoundException("set is empty");
      } else {
         response = saveRecipientInfo(request);
         for (Long setValue : validSet) {
            mapEntityList.add(new EmailRecipientInfoContactMapEntity(response.getId(), setValue));
         }
      }
      emailrecipientInfoContactMapRepository.saveAll(mapEntityList);
      response.setValidSet(validSet);
      response.setInValidList(inValidList);
      return response;
   }

   public EmailRecipientInfoResponse saveRecipientInfo(EmailRecipientInfoRequest request) {
      return EmailRecipientInfoConverter.entityToResponse(
            recipientInfoRepo.save(EmailRecipientInfoConverter.requestToEntity(request)));
   }

   @Override
   public EmailRecipientInfoResponse getRecipientInfo(Long id) {
      if (!recipientInfoRepo.existsById(id)) {
         throw new AssetNotFoundException("recepient id does not exist");
      }
      EmailRecipientInfoResponse response = EmailRecipientInfoConverter
            .entityToResponse(recipientInfoRepo.findById(id).orElse(null));
      List<Long> contactIds = new ArrayList<>();
      List<EmailRecipientInfoContactMapEntity> entities = emailrecipientInfoContactMapRepository
            .findByEmailRecipientInfoId(id);
      entities.forEach(entity -> {
         contactIds.add(entity.getContactId());
      });
      response.setContactlist(contactIds);
      return response;
   }

   @Override
   public EmailRecipientInfoResponse addToContactList(Long id, EmailRecipientInfoRequest request) {
      EmailRecipientInfoResponse response = EmailRecipientInfoConverter
            .entityToResponse(recipientInfoRepo.findById(id).orElse(null));
      if (!recipientInfoRepo.existsById(response.getId())) {
         throw new AssetNotFoundException("recepient id does not exist");
      }
      Set<Long> contacts = new HashSet<>(request.getContactlist());
      List<Long> inValidList = new ArrayList<>();
      Set<Long> validSet = new HashSet<>();
      List<EmailRecipientInfoContactMapEntity> mapEntityList = new ArrayList<>();
      for (Long contact : contacts) {
         if (contactrepository.existsById(contact)) {
            validSet.add(contact);
         } else {
            inValidList.add(contact);
         }
      }
      if (validSet.isEmpty()) {
         throw new AssetNotFoundException("set is empty");
      }
      List<Long> existedContacts = new ArrayList<>();
      List<Long> contactIds = new ArrayList<>();
      List<EmailRecipientInfoContactMapEntity> entities = emailrecipientInfoContactMapRepository
            .findByEmailRecipientInfoId(id);
      entities.stream().forEach(entity -> {
         contactIds.add(entity.getContactId());
      });
      validSet.stream().forEach(value -> {
         if (contactIds.contains(value)) {
            existedContacts.add(value);
         } else {
            mapEntityList.add(new EmailRecipientInfoContactMapEntity(response.getId(), value));
         }
      });
      emailrecipientInfoContactMapRepository.saveAll(mapEntityList);

      response.setExistedContacts(existedContacts);
      response.setInValidList(inValidList);
      return response;

   }

   @Override
   public String deleteRecipientInfo(EmailRecipientInfoRequest request) {
      // validations
      EmailRecipientInfoEntity entity = recipientInfoRepo.findById(request.getId()).orElse(null);
      if (!recipientInfoRepo.existsById(request.getId())) {
         throw new AssetNotFoundException("recepient id does not exist");
      } else {
         if (emailrecipientInfoContactMapRepository.existsByEmailRecipientInfoId(request.getId())) {
            throw new AssetNotFoundException("logically it not deleted");
         }
         // validation for deployment
         else {
            entity.setObsolete(request.getObsolete());
            recipientInfoRepo.save(entity);
            return "successfully logically deleted";
         }
      }
   }

   @Transactional
   @Override
   public EmailRecipientInfoResponse updateEmailDeployemntById(Long id, EmailRecipientInfoRequest request) {
      // EmailRecipientInfoEntity
      // entity=recipientInfoRepo.findById(request.getId()).orElse(null);
      EmailRecipientInfoEntity entity = recipientInfoRepo.findById(id).get();
      entity.setId(id);
      entity.setName(request.getName());
      entity.setObsolete(request.getObsolete());
      entity.setDescription(request.getDescription());
      EmailRecipientInfoResponse response = EmailRecipientInfoConverter
            .entityToResponse(recipientInfoRepo.save(entity));
      if (!recipientInfoRepo.existsById(id)) {
         throw new AssetNotFoundException("id does not exist");
      }
      if (!emailrecipientInfoContactMapRepository.existsByEmailRecipientInfoId(id)) {
         throw new AssetNotFoundException("EmailRecipientInfoId does not exist in recepientContactMap table");
      } // validation for deptloymentandrecepientinfoMap
      else {
         // List<EmailRecipientInfoContactMapEntity>
         // entities=emailrecipientInfoContactMapRepository.findByEmailRecipientInfoId(id);
         // entities.stream().forEach(entity->
         // {
         // contacts.add(entity.getContactId());
         // });
         emailrecipientInfoContactMapRepository.deleteByEmailRecipientInfoId(id);
         Set<Long> newContacts = new HashSet<>(request.getContactlist());
         List<Long> inValidList = new ArrayList<>();
         Set<Long> validSet = new HashSet<>();
         List<EmailRecipientInfoContactMapEntity> mapEntityList = new ArrayList<>();
         newContacts.stream().forEach(contact -> {
            if (contactrepository.existsById(contact)) {
               validSet.add(contact);
            } else {
               inValidList.add(contact);
            }
         });
         if (validSet.isEmpty()) {
            throw new AssetNotFoundException("set is empty");
         } else {
            validSet.stream().forEach(validContact -> {
               mapEntityList.add(new EmailRecipientInfoContactMapEntity(id, validContact));
            });
         }
         emailrecipientInfoContactMapRepository.saveAll(mapEntityList);
         response.setValidSet(validSet);
         response.setInValidList(inValidList);
         return response;
      }
   }
}
