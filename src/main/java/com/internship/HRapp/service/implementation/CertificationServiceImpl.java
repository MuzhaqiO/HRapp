package com.internship.HRapp.service.implementation;

import com.internship.HRapp.entity.Certification;
import com.internship.HRapp.service.interfaces.CertificationServiceInterface;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@NoArgsConstructor
public  class CertificationServiceImpl implements CertificationServiceInterface {


    @Override
    public void getCertification(Certification certification){

    }

    @Override
    public List<Certification> getCertification(){
        return null;
    }

    @Override
    public void addNewCertification(Certification certification){

    }
    @Override
    public void deleteCertification(UUID certificationId){

    }

    @Override
    public void updateCertification(UUID certificationId, String certification_name, Date expiration_year, URL link_of_certification) {

    }

}

