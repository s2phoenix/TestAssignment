package com.example.TestAssignmentService.controller;

import com.example.TestAssignmentService.model.UserInfoRequest;
import com.example.TestAssignmentService.model.UserInfoResponse;
import com.example.TestAssignmentService.service.UserInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userinfo")
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(path = "getUserInfo")
    private ResponseEntity<List<UserInfoResponse>> getUserInfo(){
        return ResponseEntity.ok(userInfoService.getUserInfo());
    }

    @GetMapping(path = "getUserInfo/{id}")
    private ResponseEntity<UserInfoResponse> getUserInfoById(@PathVariable Long id){
        return ResponseEntity.ok(userInfoService.getUserInfoById(id));
    }

    @PostMapping(path = "createUserInfo")
    private ResponseEntity<UserInfoResponse> createUserInfo(@RequestBody @Valid UserInfoRequest userInfoRequest){
        return ResponseEntity.ok(userInfoService.createUserInfo(userInfoRequest));
    }

    @PostMapping(path = "updateUserInfo/{id}")
    private ResponseEntity<UserInfoResponse> updateUserInfo(@PathVariable Long id, @RequestBody @Valid UserInfoRequest userInfoRequest){
        return ResponseEntity.ok(userInfoService.updateUserInfo(id, userInfoRequest));
    }

    @PostMapping(path = "deleteUserInfo/{id}")
    private void deleteUserInfo(@PathVariable Long id){
        userInfoService.deleteUserInfo(id);
    }

}
