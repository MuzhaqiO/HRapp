package com.internship.HRapp.controller;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.service.concretes.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping(path ="api/v1/hr_management_system/certifications")
public class CertificationController {

    private final CertificationService certificationService;

    @GetMapping("getAll")
    public ResponseEntity<List<CertificationDto>> findCertifications() {
        return ResponseEntity.ok(certificationService.getCertifications());}
    @GetMapping("getCertificationById/{certificationID}")
    public ResponseEntity<CertificationDto> findCertificationById(@PathVariable UUID certificationID){
        return ResponseEntity.ok(certificationService.getCertificationById(certificationID));
    }
    @PostMapping("addNewCertification")
    public ResponseEntity<CertificationDto> createCertification(@RequestBody CertificationDto certificationDto){
        return ResponseEntity.ok(certificationService.addNewCertification(certificationDto));
    }
    @PutMapping("editCertification/{certificationID}")
    public void editCertification(@PathVariable UUID certificationID, @RequestBody CertificationDto certificationDto){
        certificationService.editCertification(certificationID, certificationDto); }

    @DeleteMapping("deleteCertification/{certificationID}")
    public String deleteRolesById(@PathVariable UUID certificationID) {
        return certificationService.deleteCertificationById(certificationID);
    }
}
