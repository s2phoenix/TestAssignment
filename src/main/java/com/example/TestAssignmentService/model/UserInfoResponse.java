package com.example.TestAssignmentService.model;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
public class UserInfoResponse {
    private String userName;
    private String password;
    private String dateOfBirth;
}
