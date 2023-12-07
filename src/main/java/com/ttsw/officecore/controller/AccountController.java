package com.ttsw.officecore.controller;

import com.ttsw.officecore.api.ApiConstants;
import com.ttsw.officecore.model.dto.AccountDto;
import com.ttsw.officecore.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.API_OFFICE_CORE)
public class AccountController {

    private final AccountService accountService;

    @PostMapping(ApiConstants.API_OFFICE_CORE + "/account/activate/{token}")
    private ResponseEntity activateAccount(@PathVariable UUID token) {
        accountService.activateAccount(token);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/account/create")
    private ResponseEntity<Void> createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);
        return ResponseEntity.ok(null);
    }


}
