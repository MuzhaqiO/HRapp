package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.certificationDto.CertificationDto;

import java.util.List;
import java.util.UUID;

public interface CertificationServiceInterface {

    List<CertificationDto> getCertifications();

    CertificationDto addNewCertification(CertificationDto certificationDto);

    void editCertification(UUID certificationID, CertificationDto certificationDto);

    CertificationDto getCertificationById(UUID certificationid);

    void deleteCertificationById(UUID certificationID);

    List<CertificationDto> getCertificationByUserId(UUID userId);
}