package com.ttsw.officecore.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
