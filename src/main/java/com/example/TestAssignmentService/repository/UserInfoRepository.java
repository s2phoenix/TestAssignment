package com.example.TestAssignmentService.repository;

import com.example.TestAssignmentService.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
