package com.example.TestAssignmentService.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    private String dateOfBirth;
}
