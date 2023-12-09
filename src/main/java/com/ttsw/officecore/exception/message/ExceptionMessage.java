package com.ttsw.officecore.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    EMAIL_ALREADY_EXISTS("20231130:173100", "Email already exists.");

    private final String code;
    private final String message;
}
