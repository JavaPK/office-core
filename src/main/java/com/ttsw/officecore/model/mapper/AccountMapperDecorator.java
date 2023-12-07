package com.ttsw.officecore.model.mapper;

import com.ttsw.officecore.model.dto.AccountDto;
import com.ttsw.officecore.model.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

public abstract class AccountMapperDecorator implements AccountMapper {

    @Autowired
    private AccountMapper accountMapper;
    @Value("${office-core.activationToken.expireTime:48}")
    private Integer expireTime;

    @Override
    public AccountEntity toEntity(AccountDto accountDto, UUID activationToken) {

        AccountEntity accountEntity = accountMapper.toEntity(accountDto, activationToken);
        encodePassword(accountEntity);
        accountEntity.setTimestampTokenValidationTime(Date.from(Instant.now().plus(expireTime, ChronoUnit.HOURS)));

        return accountEntity;
    }

    private void encodePassword(AccountEntity accountEntity) {
        accountEntity.setPassword(accountEntity.getPassword());  //TODO do implementacji
    }


}
