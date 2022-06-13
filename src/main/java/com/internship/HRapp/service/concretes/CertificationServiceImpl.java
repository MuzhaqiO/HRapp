package com.internship.HRapp.service.concretes;


import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.entity.Certification;
import com.internship.HRapp.mapper.CertificationMapper;
import com.internship.HRapp.repository.CertificationRepo;
import com.internship.HRapp.service.interfaces.CertificationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationServiceInterface {

    private final CertificationRepo certificationRepo;
    private final CertificationMapper certificationMapper;

    @Override
    public CertificationDto getCertificationById(UUID certificationID) {
        return certificationMapper.modeltoDto(certificationRepo.getById(certificationID));
    }

    @Override
    public List<CertificationDto> getCertifications() {
        return certificationMapper.toDto(certificationRepo.findAll());
    }

    @Override
    public CertificationDto addNewCertification(CertificationDto certificationDto) {
        Certification createdCertification = certificationRepo.save(certificationMapper.dtotoModel(certificationDto));
        return certificationMapper.modeltoDto(createdCertification);
    }

    @Override
    public String deleteCertificationById(UUID certificationId) {
        certificationRepo.deleteById(certificationId);
        return "certification removed {}" + certificationId;
    }

    @Override
    public void editCertification(CertificationDto certificationDto) {
        Certification certification = certificationRepo.findCertificationByCertificationID(certificationDto.getCertificationID());
        certification.setCertification_name(certificationDto.getCertification_name());
        certification.setCertification_year(certificationDto.getCertification_year());
        certification.setExpiration_date(certificationDto.getExpiration_date());
        certification.setReleasing_authority(certificationDto.getReleasing_authority());
        certification.setLink_of_certification(certificationDto.getLink_of_certification());
        certificationRepo.save(certification);
    }

}