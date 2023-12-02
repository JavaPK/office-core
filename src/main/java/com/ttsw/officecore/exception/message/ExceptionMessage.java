package com.ttsw.officecore.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    EMAIL_ALREADY_EXISTS("20231130:173100", "Email already exists."),
    EMAIL_NOT_VALID("20231202:224300:", "Email is not valid."),
    PASSWORD_NOT_VALID("20231202:224500", "Password is not valid."),
    NULL_EMAIL_OR_PASSWORD("20231202:223600", "Email or password is null.");

    private String code;
    private String message;
}
