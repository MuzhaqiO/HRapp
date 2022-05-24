package com.internship.HRapp.controller;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.service.interfaces.CertificationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping(path ="api/v1/hr_menagement_system/certifications")
public class CertificationController {

    private final CertificationServiceInterface certificationServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<CertificationDto>> findCertifications() {  return ResponseEntity.ok(certificationServiceInterface.getCertifications());}
    @GetMapping("id/{certificationID}")
    public ResponseEntity<CertificationDto> findCertificationById(@PathVariable UUID certificationID){
        return ResponseEntity.ok(certificationServiceInterface.getCertificationById(certificationID));
    }
    @PostMapping("addNewCertification")
    public ResponseEntity<CertificationDto> createCertification(@RequestBody CertificationDto certificationDto){
        return ResponseEntity.ok(certificationServiceInterface.addNewCertification(certificationDto));
    }
    @PutMapping("edit/{certificationid}")
    public void editCertification(@RequestBody CertificationDto certificationDto){
        certificationServiceInterface.editCertification(certificationDto); }

    @DeleteMapping("delete/{certificationID}")
    public String deleteRolesById(@PathVariable UUID certificationID) {
        return certificationServiceInterface.deleteCertificationById(certificationID);
    }
}
