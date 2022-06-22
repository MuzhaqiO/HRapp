package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.entity.Certification;
import com.internship.HRapp.mapper.CertificationMapper;
import com.internship.HRapp.repository.CertificationRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.CertificationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class CertificationService implements CertificationServiceInterface {
    private final CertificationRepo certificationRepo;
    private final CertificationMapper certificationMapper;
    private final UserRepo userRepo;

    @Override
    public CertificationDto getCertificationById(UUID certificationID) {
        boolean exists = certificationRepo.existsById(certificationID);
        if (!exists) {
            throw new IllegalStateException(
                    "Certification with id " + certificationID + " does not exist!"
            );
        }
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
    public void deleteCertificationById(UUID certificationId) {
        boolean exists = certificationRepo.existsById(certificationId);
        if (!exists) {
            throw new IllegalStateException(
                    "Certification with id " + certificationId + " does not exist!"
            );
        }
        certificationRepo.deleteById(certificationId);
    }

    @Override
    public List<CertificationDto> getCertificationByUserId(UUID userId) {
        boolean exists = userRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exist");
        }
        return certificationMapper.toDto(certificationRepo.getCertificationByUsersUserId(userId));
    }

    @Override
    public void editCertification(UUID certificationID, CertificationDto certificationDto) {
        Certification certification = certificationRepo.getById(certificationID);
        certification.setCertification_name(certificationDto.getCertification_name());
        certification.setCertification_year(certificationDto.getCertification_year());
        certification.setExpiration_date(certificationDto.getExpiration_date());
        certification.setReleasing_authority(certificationDto.getReleasing_authority());
        certification.setLink_of_certification(certificationDto.getLink_of_certification());
        certificationRepo.save(certification);
    }
}
