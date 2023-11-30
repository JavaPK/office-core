package com.ttsw.officecore.controller;

import com.ttsw.officecore.exception.ValidationException;
import com.ttsw.officecore.exception.dto.ErrorDTO;
import com.ttsw.officecore.exception.dto.ErrorsDTO;
import com.ttsw.officecore.exception.message.ExceptionMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ExampleController {


    @GetMapping
    public ResponseEntity exception() {
        ErrorsDTO errorsDTO = ErrorsDTO.builder()
                .erorrs(List.of(ErrorDTO.of( UUID.randomUUID(), ExceptionMessage.EMAIL_ALREADY_EXISTS.getMessage())))
                .build();

        throw new ValidationException(errorsDTO);
    }
}
