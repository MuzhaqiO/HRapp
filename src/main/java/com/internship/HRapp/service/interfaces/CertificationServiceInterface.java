package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Certification;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface CertificationServiceInterface {
        void getCertification(Certification certification);

        List<Certification> getCertification();

        void addNewCertification(Certification certification);

        void deleteCertification(UUID certificationId);

        void updateCertification(UUID CertificationId, String certification_name, Date expiration_year, URL link_of_certification);
    }