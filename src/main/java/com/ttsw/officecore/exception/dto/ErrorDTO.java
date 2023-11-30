package com.ttsw.officecore.exception.dto;

import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class ErrorDTO {

    private UUID uuid;
    private String message;
}
