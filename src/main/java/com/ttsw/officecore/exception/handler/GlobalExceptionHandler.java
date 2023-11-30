package com.ttsw.officecore.exception.handler;

import com.ttsw.officecore.exception.ValidationException;
import com.ttsw.officecore.exception.dto.ErrorsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorsDTO> handleValidationException(ValidationException exception){
        log.error(String.format("UUID: [%s] - Validation error.", UUID.randomUUID()), exception);
        return ResponseEntity.badRequest()
                .body(exception.getErrorsDTO());
    }

}
