package com.ttsw.officecore.service;

import com.ttsw.officecore.model.dto.OfficeDto;
import com.ttsw.officecore.model.mapper.OfficeMapper;
import com.ttsw.officecore.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OfficeServiceImpl implements OfficeService{
    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    @Override
    public void createOffice(OfficeDto officeDto) {
        officeRepository.save(officeMapper.toEntity(officeDto));
    }

}
