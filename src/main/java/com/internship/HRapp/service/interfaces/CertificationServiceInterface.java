package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface CertificationServiceInterface {


        List<CertificationDto> getCertifications();
        CertificationDto addNewCertification(CertificationDto certificationDto);
        void editCertification(CertificationDto certificationDto);
        CertificationDto getCertificationById(UUID certificationid);

        String deleteCertificationById(UUID certificationID);
}