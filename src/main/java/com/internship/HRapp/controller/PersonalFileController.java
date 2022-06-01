package com.internship.HRapp.controller;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
import com.internship.HRapp.service.concretes.PersonalFileServicelmpl;
import com.internship.HRapp.service.interfaces.PersonalFileInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping (path ="api/v1/hr_management_system/personalfiles")
@RequiredArgsConstructor
public class PersonalFileController {
    private final PersonalFileServicelmpl personalFileService;

    @GetMapping("getAll")
    public ResponseEntity<List<PersonalFileDto>> findAllPersonalFiles(){
        return ResponseEntity.ok(personalFileService.getPersonalFiles());
    }
    @PostMapping("/addNewPersonalFile")
    public ResponseEntity<PersonalFileDto> createNewPersonalFile(@RequestBody PersonalFileDto personalFileDto) {
        return ResponseEntity.ok(personalFileService.addNewPersonalFile(personalFileDto));
    }
    @PutMapping("editPersonalFile/{personalfileId}")
    public void editPersonalFile(@RequestParam PersonalFileDto personalFileDto){
        personalFileService.editPersonalFile(personalFileDto);
    }
    @GetMapping("id/{personalfileId}")
    public ResponseEntity<PersonalFileDto> findPersonalFileById(@PathVariable UUID personalfileId){
        return ResponseEntity.ok(personalFileService.getPersonalFileById(personalfileId));
    }
    @DeleteMapping("delete/{personalfileId}")
    public String deleteRolesById(@PathVariable UUID personalfileId) {
        return personalFileService.deletePersonalFileById(personalfileId);
    }
}