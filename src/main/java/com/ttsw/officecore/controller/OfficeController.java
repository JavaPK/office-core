package com.ttsw.officecore.controller;

import com.ttsw.officecore.model.dto.OfficeDto;
import com.ttsw.officecore.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "office")
public class OfficeController {

    private final OfficeService officeService;

    @PostMapping
    public void createOffice(@RequestBody OfficeDto officeDto){
        officeService.createOffice(officeDto);
    }
}
