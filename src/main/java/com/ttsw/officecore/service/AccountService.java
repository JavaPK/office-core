package com.ttsw.officecore.service;

import com.ttsw.officecore.common.AccountDto;

import java.util.UUID;

public interface AccountService {

    void activateAccount(UUID token);

    void createAccount(AccountDto accountDto);
}
