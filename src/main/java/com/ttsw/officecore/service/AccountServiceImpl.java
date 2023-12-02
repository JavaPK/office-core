package com.ttsw.officecore.service;

import com.ttsw.officecore.common.AccountDto;
import com.ttsw.officecore.validation.AccountCreationValidation;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@NoArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public void activateAccount(UUID token) {

    }

    @Override
    public void createAccount(AccountDto accountDto) {
        if (AccountCreationValidation.validate(accountDto)) {

        }
    }


}
