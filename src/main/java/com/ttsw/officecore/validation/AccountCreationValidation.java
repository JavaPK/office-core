package com.ttsw.officecore.validation;

import com.ttsw.officecore.common.AccountDto;

import java.util.regex.Pattern;

public class AccountCreationValidation {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static boolean validate(AccountDto accountDto) {
        if (accountDto.getEmail() == null || accountDto.getPassword() == null) {
            throw new IllegalArgumentException("Email or password is null");
        } else if (!emailValidation(accountDto.getEmail())) {
            throw new IllegalArgumentException("Email is not valid");
        } else if (!passwordValidation(accountDto.getPassword())) {
            throw new IllegalArgumentException("Password is not valid");
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
