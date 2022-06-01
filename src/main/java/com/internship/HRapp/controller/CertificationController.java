package com.internship.HRapp.controller;

import com.internship.HRapp.entity.Certification;
import com.internship.HRapp.service.implementation.CertificationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path ="api/v1/hr/menagment_system")
@NoArgsConstructor
public class CertificationController {

    private CertificationServiceImpl certificationServiceImpl;

    @GetMapping("/{certificationid}")
    public List<Certification> getCertification(){
        return certificationServiceImpl.getCertification();
    }
    public void getCertification(Certification certification){
        certificationServiceImpl.getCertification(certification);
    }
    @PostMapping
    public void registerNewCertification(@RequestBody Certification certification){
        certificationServiceImpl.addNewCertification(certification);
    }
    @DeleteMapping(path = "{certifiactionid}")
    public void deleteCertification(@PathVariable ("certificationid") UUID certifiactionid){
        certificationServiceImpl.deleteCertification(certifiactionid);
    }
    @PutMapping()
    public void updateCertification(
            @RequestParam UUID certificationId,
            @RequestParam(required = false) String certification_name,
            @RequestParam(required = false) Date expiration_year,
            @RequestParam(required = false) URL link_of_certification){
                certificationServiceImpl.updateCertification( certificationId,certification_name,expiration_year,link_of_certification);
    }
}
