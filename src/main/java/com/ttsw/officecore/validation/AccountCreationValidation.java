package com.ttsw.officecore.validation;

import com.ttsw.officecore.common.AccountDto;
import com.ttsw.officecore.exception.ValidationException;
import com.ttsw.officecore.exception.dto.ErrorDTO;
import com.ttsw.officecore.exception.dto.ErrorsDTO;
import com.ttsw.officecore.exception.message.ExceptionMessage;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class AccountCreationValidation {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static boolean validate(AccountDto accountDto) {
        ErrorsDTO errorsDTO;

        if (accountDto.getEmail() == null || accountDto.getPassword() == null) {
            errorsDTO = ErrorsDTO.builder()
                    .erorrs(List.of(ErrorDTO.of(UUID.randomUUID(), ExceptionMessage.EMAIL_ALREADY_EXISTS.getMessage())))
                    .build();

            throw new ValidationException(errorsDTO);
        } else if (!emailValidation(accountDto.getEmail())) {
            errorsDTO = ErrorsDTO.builder()
                    .erorrs(List.of(ErrorDTO.of(UUID.randomUUID(), ExceptionMessage.EMAIL_NOT_VALID.getMessage())))
                    .build();

            throw new ValidationException(errorsDTO);
        } else if (!passwordValidation(accountDto.getPassword())) {
            errorsDTO = ErrorsDTO.builder()
                    .erorrs(List.of(ErrorDTO.of(UUID.randomUUID(), ExceptionMessage.PASSWORD_NOT_VALID.getMessage())))
                    .build();

            throw new ValidationException(errorsDTO);
        } else {
            return true;
        }
    }

    private static boolean emailValidation(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }

    private static boolean passwordValidation(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        return pattern.matcher(password).matches();
    }
}