package com.internship.HRapp.controller;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
import com.internship.HRapp.service.concretes.PersonalFileService;
import com.internship.HRapp.service.interfaces.PersonalFileInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping (path ="api/v1/hr_management_system/personalFiles")
@RequiredArgsConstructor
public class PersonalFileController {
    private final PersonalFileInterface personalFileServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<PersonalFileDto>> findAllPersonalFiles(){
        return ResponseEntity.ok(personalFileServiceInterface.getPersonalFiles());
    }
    @PostMapping("addNewPersonalFile")
    public ResponseEntity<PersonalFileDto> createNewPersonalFile(@RequestBody PersonalFileDto personalFileDto) {
        return ResponseEntity.ok(personalFileServiceInterface.addNewPersonalFile(personalFileDto));
    }
    @PutMapping("editPersonalFile/{personalFileId}")
    public ResponseEntity<PersonalFileDto> editPersonalFile(@RequestBody PersonalFileDto personalFileDto){
        return ResponseEntity.ok(personalFileServiceInterface.editPersonalFile(personalFileDto));
    }
    @GetMapping("getPersonalFile/{personalFileId}")
    public ResponseEntity<PersonalFileDto> findPersonalFileById(@PathVariable UUID personalFileId){
        return ResponseEntity.ok(personalFileServiceInterface.getPersonalFileById(personalFileId));
    }
    @GetMapping("getPersonalFileByUser/{userId}")
    public ResponseEntity<List<PersonalFileDto>> getPersonalFileByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(personalFileServiceInterface.getPersonalFileByUserId(userId));
    }
    @DeleteMapping("deletePersonalFile/{personalFileId}")
    public String deleteRolesById(@PathVariable UUID personalFileId) {
        return personalFileServiceInterface.deletePersonalFileById(personalFileId);
    }
}