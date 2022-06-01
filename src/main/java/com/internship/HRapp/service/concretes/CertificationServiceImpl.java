package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.entity.Certification;
import com.internship.HRapp.mapper.CertificationMapper;
import com.internship.HRapp.repository.CertificationRepo;
import com.internship.HRapp.service.interfaces.CertificationServiceInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public  class CertificationServiceImpl{
    @Autowired
    private final CertificationRepo certificationRepo;
    @Autowired
    private final CertificationMapper certificationMapper;

    public CertificationDto getCertificationById(UUID certificationID){
        boolean exists = certificationRepo.existsById(certificationID);
        if (!exists){
            throw new IllegalStateException(
                    "Certification with id " + certificationID + " does not exist!"
            );
        }
    return certificationMapper.modeltoDto(certificationRepo.getById(certificationID));
    }

    public List<CertificationDto> getCertifications(){
        return certificationMapper.toDto(certificationRepo.findAll());
    }

    public CertificationDto addNewCertification(CertificationDto certificationDto){
    Certification createdCertification = certificationRepo.save(certificationMapper.dtotoModel(certificationDto));
        return certificationMapper.modeltoDto(createdCertification);
    }

    public String deleteCertificationById(UUID certificationId){
        boolean exists = certificationRepo.existsById(certificationId);
        if (!exists){
            throw new IllegalStateException(
                    "Certification with id " + certificationId + " does not exist!"
            );
        }
        certificationRepo.deleteById(certificationId);
        return "Certification removed {}" + certificationId;
    }

    public void editCertification(CertificationDto certificationDto) {
    Certification certification =certificationRepo.findCertificationByCertificationID(certificationDto.getCertificationID());
    certification.setCertification_name(certificationDto.getCertification_name());
    certification.setCertification_year(certificationDto.getCertification_year());
    certification.setExpiration_date(certificationDto.getExpiration_date());
    certification.setReleasing_authority(certificationDto.getReleasing_authority());
    certification.setLink_of_certification(certificationDto.getLink_of_certification());
    certificationRepo.save(certification);
    }

}

