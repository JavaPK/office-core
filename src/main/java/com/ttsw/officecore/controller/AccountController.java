package com.ttsw.officecore.controller;

import com.ttsw.officecore.api.ApiConstants;
import com.ttsw.officecore.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping(ApiConstants.API_OFFICE_CORE + "/account/activate/{token}")
    private ResponseEntity activateAccount(@PathVariable UUID token) {
        accountService.activateAccount(token);

        return ResponseEntity.ok(null);
    }


}
