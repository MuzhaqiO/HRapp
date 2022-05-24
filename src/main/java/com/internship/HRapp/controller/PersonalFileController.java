package com.internship.HRapp.controller;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
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
    private final PersonalFileInterface personalFileInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<PersonalFileDto>> findAllPersonalFiles(){return ResponseEntity.ok(personalFileInterface.getPersonalFiles());
    }
    @PostMapping("/addNewPersonalFile")
    public ResponseEntity<PersonalFileDto> createNewPersonalFile(@RequestBody PersonalFileDto personalFileDto) {
        return ResponseEntity.ok(personalFileInterface.addNewPersonalFile(personalFileDto));
    }
    @PutMapping("editPersonalFile/{personalfileId}")
    public void editPersonalFile(@RequestParam PersonalFileDto personalFileDto){
        personalFileInterface.editPersonalFile(personalFileDto);
    }


    @GetMapping("id/{personalfileId}")
    public ResponseEntity<PersonalFileDto> findPersonalFileById(@PathVariable UUID personalfileId){
        return ResponseEntity.ok(personalFileInterface.getPersonalFileById(personalfileId));
    }
    @DeleteMapping("delete/{personalfileId}")
    public String deleteRolesById(@PathVariable UUID personalfileId) {
        return personalFileInterface.deletePersonalFileById(personalfileId);
    }
}