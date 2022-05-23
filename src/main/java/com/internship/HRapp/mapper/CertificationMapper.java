package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.entity.Certification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificationMapper {
    CertificationDto modeltoDto(Certification certification);
    Certification dtotoModel(CertificationDto certificationDto);
    List<CertificationDto> toDto(List<Certification> certifications);
    List<Certification> toModel(List<CertificationDto> certificationDtos);

}
