package com.ttsw.officecore.controller;

import com.ttsw.officecore.security.dto.LoginDTO;
import com.ttsw.officecore.security.dto.RefreshTokenDTO;
import com.ttsw.officecore.security.dto.TokenDTO;
import com.ttsw.officecore.security.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(accountService.login(loginDTO), HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<TokenDTO> refreshToken(@Valid @RequestBody RefreshTokenDTO refreshTokenDTO) {
        return ResponseEntity.ok(accountService.refreshToken(refreshTokenDTO));
    }
}
