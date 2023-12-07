package com.ttsw.officecore.model.mapper;

import com.ttsw.officecore.model.dto.AccountDto;
import com.ttsw.officecore.model.entity.AccountEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
@DecoratedWith(AccountMapperDecorator.class)
public interface AccountMapper {


    AccountEntity toEntity(AccountDto accountDto, UUID activationToken);
}
