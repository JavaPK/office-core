package com.ttsw.officecore.model.mapper;

import com.ttsw.officecore.model.dto.OfficeDto;
import com.ttsw.officecore.model.entity.Office;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfficeMapper {

    OfficeDto toDto(Office source);

    Office toEntity(OfficeDto source);
}
