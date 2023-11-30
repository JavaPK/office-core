package com.ttsw.officecore.exception.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ErrorsDTO {
    private List<ErrorDTO> erorrs;
}
