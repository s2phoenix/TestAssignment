package com.example.TestAssignmentService.service;

import com.example.TestAssignmentService.entity.UserInfo;
import com.example.TestAssignmentService.model.UserInfoRequest;
import com.example.TestAssignmentService.model.UserInfoResponse;
import com.example.TestAssignmentService.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public List<UserInfoResponse> getUserInfo(){
        List<UserInfo> optionalList = userInfoRepository.findAll();
        List<UserInfoResponse> responseList = new ArrayList<>();
        if(!optionalList.isEmpty()){
            responseList = optionalList.stream().map( userInfo -> {
                return UserInfoResponse.builder()
                        .userName(userInfo.getUserName())
                        .password(userInfo.getPassword())
                        .dateOfBirth(userInfo.getDateOfBirth())
                        .build();

            }).collect(Collectors.toList());
        }
        return responseList;
    }

    public UserInfoResponse getUserInfoById(Long id){
        Optional<UserInfo> optionalList = userInfoRepository.findById(id);
        if(optionalList.isPresent()){
            return UserInfoResponse.builder()
                    .userName(optionalList.get().getUserName())
                    .password(optionalList.get().getPassword())
                    .dateOfBirth(optionalList.get().getDateOfBirth())
                    .build();
        } else {
            throw new RuntimeException("User ID Not Found");
        }
    }

    public UserInfoResponse createUserInfo(UserInfoRequest userInfoRequest){
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userInfoRequest.getUserName());
            userInfo.setPassword(userInfoRequest.getPassword());
            userInfo.setDateOfBirth(userInfoRequest.getDateOfBirth());
            userInfoRepository.save(userInfo);
            return UserInfoResponse.builder()
                    .userName(userInfo.getUserName())
                    .password(userInfo.getPassword())
                    .dateOfBirth(userInfo.getDateOfBirth())
                    .build();
        } catch (Exception e){
            throw new RuntimeException("Create User Failed");
        }
    }

    public UserInfoResponse updateUserInfo(Long id,UserInfoRequest userInfoRequest){
        try {
            Optional<UserInfo> userInfo = userInfoRepository.findById(id);
            if(userInfo.isPresent()) {
                UserInfo updatedUserInfo = userInfo.get();
                updatedUserInfo.setUserName(userInfoRequest.getUserName());
                updatedUserInfo.setPassword(userInfoRequest.getPassword());
                updatedUserInfo.setDateOfBirth(userInfoRequest.getPassword());
                userInfoRepository.save(updatedUserInfo);
                return UserInfoResponse.builder()
                        .userName(updatedUserInfo.getUserName())
                        .password(updatedUserInfo.getPassword())
                        .dateOfBirth(updatedUserInfo.getDateOfBirth())
                        .build();
            } else {
                throw new RuntimeException("User ID Not Found");
            }

        } catch (Exception e){
            throw new RuntimeException("Update User Failed");
        }
    }

    public void deleteUserInfo(Long id){
        try {
            userInfoRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Delete User Failed");
        }
    }
}
