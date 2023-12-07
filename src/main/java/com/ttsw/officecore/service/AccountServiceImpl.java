package com.ttsw.officecore.service;

import com.ttsw.officecore.model.dto.AccountDto;
import com.ttsw.officecore.model.entity.AccountEntity;
import com.ttsw.officecore.model.mapper.AccountMapper;
import com.ttsw.officecore.repository.AccountRepository;
import com.ttsw.officecore.validation.AccountCreationValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountCreationValidation accountCreationValidation;
    private final AccountMapper accountMapper;

    @Override
    public void activateAccount(UUID token) {

    }

    @Override
    public void createAccount(AccountDto accountDto) {
        accountCreationValidation.validate(accountDto);
        AccountEntity newAccount = accountMapper.toEntity(accountDto, UUID.randomUUID());
        accountRepository.save(newAccount);
    }


}
