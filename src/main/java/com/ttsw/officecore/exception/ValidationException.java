package com.ttsw.officecore.exception;

import com.ttsw.officecore.exception.dto.ErrorsDTO;
import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private static final String MESSAGE = "Validatation exception occured";

    public ValidationException(ErrorsDTO errorsDTO) {
        super(MESSAGE);
        this.errorsDTO = errorsDTO;
    }

    private ErrorsDTO errorsDTO;
}
