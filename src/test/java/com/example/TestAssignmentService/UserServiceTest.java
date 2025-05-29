package com.example.TestAssignmentService;

import com.example.TestAssignmentService.entity.UserInfo;
import com.example.TestAssignmentService.model.UserInfoRequest;
import com.example.TestAssignmentService.model.UserInfoResponse;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import com.example.TestAssignmentService.repository.UserInfoRepository;
import com.example.TestAssignmentService.service.UserInfoService;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceTest {
    @Mock
    private UserInfoRepository userInfoRepository;

    @InjectMocks
    private UserInfoService userInfoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUserInfo_success() {
        UserInfoRequest request = new UserInfoRequest();
        request.setUserName("Ms.");
        request.setPassword("Dahye2");
        request.setDateOfBirth("01/01/1990");

        UserInfo savedUser = new UserInfo();
        savedUser.setUserName(request.getUserName());
        savedUser.setPassword(request.getPassword());
        savedUser.setDateOfBirth(request.getDateOfBirth());

        when(userInfoRepository.save(any(UserInfo.class))).thenReturn(savedUser);

        UserInfoResponse response = userInfoService.createUserInfo(request);

        assertNotNull(response);
        assertEquals("Ms.", response.getUserName());
        assertEquals("Dahye2", response.getPassword());
        assertEquals("01/01/1990", response.getDateOfBirth());
    }
}
