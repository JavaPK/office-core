package com.ttsw.officecore.exception.handler;

import com.ttsw.officecore.exception.ValidationException;
import com.ttsw.officecore.exception.dto.ErrorDTO;
import com.ttsw.officecore.exception.dto.ErrorsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorsDTO> handleValidationException(ValidationException exception) {
        log.error(String.format("UUID: [%s] - Validation error.", UUID.randomUUID()), exception);
        return ResponseEntity.badRequest()
                .body(exception.getErrorsDTO());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorsDTO> handleInternalAuthenticationServiceException(BadCredentialsException exception) {
        log.error(String.format("UUID: [%s] - Bad credentials error.", UUID.randomUUID()), exception);
        return new ResponseEntity<>(ErrorsDTO.builder()
                .erorrs(
                        List.of(ErrorDTO.of(UUID.randomUUID(), "Bad credentials"))
                ).build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorDTO> errorList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errorList.add(ErrorDTO.of(UUID.randomUUID(), String.format("Field: %s - %s", fieldName, errorMessage)));
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorsDTO.builder().erorrs(errorList).build());
    }
}
