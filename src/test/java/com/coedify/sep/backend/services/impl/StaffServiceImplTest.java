// package com.coedify.sep.backend.services.impl;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import com.coedify.sep.backend.commons.converter.StaffConverter;
// import com.coedify.sep.backend.commons.enums.StaffType;
// import com.coedify.sep.backend.models.dto.request.StaffRequest;
// import com.coedify.sep.backend.models.dto.response.StaffResponse;
// import com.coedify.sep.backend.models.entity.StaffEntity;
// import com.coedify.sep.backend.models.repository.StaffRepository;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// @ExtendWith(SpringExtension.class)
// public class StaffServiceImplTest {
    
//     @Mock
//     private StaffRepository staffRepository;
//     @InjectMocks
//     private StaffServiceImpl staffServiceImpl;

//     @Test
//     void givenValidStaffRequest_createARequest_returnResponse(){
//         StaffRequest request = new StaffRequest();

//         request.setName("Zia");
//         request.setEmail("zianaqvi7@gmail.com");
//         request.setMobileNumber(9990766146l);
//         request.setStaffType(StaffType.INTERN);


//         StaffEntity responseFromDataBase = new StaffEntity();

//         responseFromDataBase.setName("Zia");
//         responseFromDataBase.setEmail("zianaqvi7@gmail.com");
//         responseFromDataBase.setMobileNumber(9990766146l);
//         responseFromDataBase.setStaffType(StaffType.INTERN);    
//         responseFromDataBase.setId(1l);

//         when(staffRepository.save(StaffConverter.requestToEntity(request))).thenReturn(responseFromDataBase);
      

//         StaffResponse actual = staffServiceImpl.createARequest(request);

//         assertEquals("Zia", actual.getName());
//         assertEquals("zianaqvi7@gmail.com", actual.getEmail());
//         assertEquals(9990766146l, actual.getMobileNumber());
//         assertEquals(1l, actual.getId());
//         assertEquals(StaffType.INTERN, actual.getStaffType());
//     }

//     @Test
//     void givenValidStaffId_getDeveloper_returnResponse(){
//         Long requestId=1l;
        
//         StaffEntity responseFromDataBase = new StaffEntity();

//         responseFromDataBase.setName("Zia");
//         responseFromDataBase.setEmail("zianaqvi7@gmail.com");
//         responseFromDataBase.setMobileNumber(9990766146l);
//         responseFromDataBase.setStaffType(StaffType.INTERN);    
//         responseFromDataBase.setId(1l); 

//         when(staffRepository.findById(requestId)).thenReturn(Optional.of(responseFromDataBase));
        

//         StaffResponse actual = staffServiceImpl.getStaff(requestId);

//         assertEquals("Zia", actual.getName());
//         assertEquals("zianaqvi7@gmail.com", actual.getEmail());
//         assertEquals(9990766146l, actual.getMobileNumber());
       
//         assertEquals(StaffType.INTERN, actual.getStaffType());
    


//     }

//     @Test
//     void getAllStaff_returnResponse(){
//         List<StaffEntity> resonseList=new ArrayList<>();
        
//         StaffEntity response1 = new StaffEntity();
//         response1.setName("Zia");
//         response1.setEmail("zianaqvi7@gmail.com");
//         response1.setMobileNumber(9990766146l);
//         response1.setStaffType(StaffType.INTERN);    
//         response1.setId(1l);
//         resonseList.add(response1);

//         StaffEntity response2 = new StaffEntity();
//         response2.setName("Ariba");
//         response2.setEmail("ariba@gmail.com");
//         response2.setMobileNumber(9890766146l);
//         response2.setStaffType(StaffType.FULLTIME);    
//         response2.setId(2l);
//         resonseList.add(response2);

//         when(staffRepository.findAll()).thenReturn(resonseList);
        

//         List<StaffResponse> actual = staffServiceImpl.getAllStaff();

//         assertEquals("Zia", actual.get(0).getName());
//         assertEquals("zianaqvi7@gmail.com", actual.get(0).getEmail());
//         assertEquals(9990766146l, actual.get(0).getMobileNumber());
//         assertEquals(StaffType.INTERN, actual.get(0).getStaffType());

//         assertEquals("Ariba", actual.get(1).getName());
//         assertEquals("ariba@gmail.com", actual.get(1).getEmail());
//         assertEquals(9890766146l, actual.get(1).getMobileNumber());
//         assertEquals(StaffType.FULLTIME, actual.get(1).getStaffType());
    


//     }
// }



