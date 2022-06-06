package com.internship.HRapp.controller;

import com.internship.HRapp.dto.certificationDto.AssignCertificationDTO;
import com.internship.HRapp.dto.educationDto.AssignEducationDTO;
import com.internship.HRapp.dto.experiencesDTO.AssignExperiencesDTO;
import com.internship.HRapp.dto.personalfileDto.AssignPersonalFileDTO;
import com.internship.HRapp.dto.projectsDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.roleDTO.RemoveRoleDTO;
import com.internship.HRapp.dto.roleDTO.UpdateRoleDTO;
import com.internship.HRapp.dto.roleDTO.UpdateUsersRoleDto;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserServiceInterface userServiceInterface;
    @GetMapping("getAll")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userServiceInterface.getUsers());
    }
    @GetMapping("username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userServiceInterface.getUserByUsername(username));
    }
    @GetMapping("userId/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId){
        return ResponseEntity.ok(userServiceInterface.getUserById(userId));
    }
    @PostMapping("addNewUser")
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userServiceInterface.addNewUser(userCreateDTO));
    }
    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserUpdateDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO){
        return ResponseEntity.ok(userServiceInterface.updateUser(userUpdateDTO));
    }
    @PatchMapping("updateUsername/{userId}")
    public ResponseEntity<UsernameDTO> updateUsername(@PathVariable UUID userId, @RequestBody UsernameDTO usernameDTO){
        return ResponseEntity.ok(userServiceInterface.updateUsername(userId, usernameDTO));
    }
    @PatchMapping("updatePassword/{userId}")
    public ResponseEntity<PasswordDTO> updatePassword(@PathVariable UUID userId, @RequestBody PasswordDTO passwordDTO){
        return ResponseEntity.ok(userServiceInterface.updatePassword(userId, passwordDTO));
    }
    @PatchMapping("updateUsersStatus/{userId}")
    public ResponseEntity<UsersStatusDTO> updateUsersStatus(@PathVariable UUID userId, @RequestBody UsersStatusDTO usersStatusDTO){
        return ResponseEntity.ok(userServiceInterface.updateUsersStatus(userId, usersStatusDTO));
    }
    @PatchMapping("assignRole/{userId}")
    public ResponseEntity<AssignRoleDTO> assignRoleToUser(@PathVariable UUID userId, @RequestBody AssignRoleDTO assignRoleDTO){
        return ResponseEntity.ok(userServiceInterface.assignRoleToUser(userId, assignRoleDTO));
    }
    @PatchMapping("removeRole/{userId}")
    public ResponseEntity<UpdateRoleDTO> removeRoleFromUser(@PathVariable UUID userId, @RequestParam UUID roleId){
        return ResponseEntity.ok(userServiceInterface.removeRoleFromUser(userId, roleId));
    }
    @PatchMapping("assignPersonalFile/{userId}")
    public ResponseEntity<AssignPersonalFileDTO> assignPersonalFileToUser(@PathVariable UUID userId, @RequestBody AssignPersonalFileDTO assignPersonalFileDTO){
        return ResponseEntity.ok(userServiceInterface.assignPersonalFileToUser(userId, assignPersonalFileDTO));
    }
    @PatchMapping("removePersonalFile/{userId}")
    public ResponseEntity<AssignPersonalFileDTO> removePersonalFileFromUser(@PathVariable UUID userId, @RequestParam UUID personalFileId){
        return ResponseEntity.ok(userServiceInterface.removePersonalFileFromUser(userId, personalFileId));
    }
//    @PatchMapping("updateUsersRole/{userId}")
//    public ResponseEntity<UpdateRoleDTO> updateUsersRole2(@PathVariable UUID userId, @RequestBody UpdateRoleDTO updateRoleDTO){
//        return ResponseEntity.ok(userServiceInterface
//       .updateRole2(userId, updateRoleDTO));
//    }
    @PatchMapping("assignProject/{userId}")
    public ResponseEntity<ProjectAssignDTO> assignProjectToUser(@PathVariable UUID userId, @RequestBody ProjectAssignDTO projectAssignDTO){
        return ResponseEntity.ok(userServiceInterface.assignProjectToUser(userId, projectAssignDTO));
    }
    @PatchMapping("removeProject/{userId}")
    public ResponseEntity<ProjectAssignDTO> removeProjectFromUser(@PathVariable UUID userId, @RequestParam UUID projectId){
        return ResponseEntity.ok(userServiceInterface.removeProjectFromUser(userId, projectId));
    }
    @PatchMapping("assignExperience/{userId}")
    public ResponseEntity<AssignExperiencesDTO> assignExperienceToUser(@PathVariable UUID userId, @RequestBody AssignExperiencesDTO assignExperiencesDTO){
        return ResponseEntity.ok(userServiceInterface.assignExperienceToUser(userId, assignExperiencesDTO));
    }
    @PatchMapping("removeExperience/{userId}")
    public ResponseEntity<AssignExperiencesDTO> removeExperienceFromUser(@PathVariable UUID userId, @RequestParam UUID expId){
        return ResponseEntity.ok(userServiceInterface.removeExperienceFromUser(userId, expId));
    }
    @PatchMapping("assignEducation/{userId}")
    public ResponseEntity<AssignEducationDTO> assignEducationToUser(@PathVariable UUID userId, @RequestBody AssignEducationDTO assignEducationDTO){
        return ResponseEntity.ok(userServiceInterface.assignEducationToUser(userId, assignEducationDTO));
    }
    @PatchMapping("removeEducation/{userId}")
    public ResponseEntity<AssignEducationDTO> removeEducationFromUser(@PathVariable UUID userId, @RequestParam UUID educationId){
        return ResponseEntity.ok(userServiceInterface.removeEducationFromUser(userId, educationId));
    }
    @PatchMapping("assignCertification/{userId}")
    public ResponseEntity<AssignCertificationDTO> assignCertificationToUser(@PathVariable UUID userId, @RequestBody AssignCertificationDTO assignCertificationDTO){
        return ResponseEntity.ok(userServiceInterface.assignCertificationToUser(userId, assignCertificationDTO));
    }
    @PatchMapping("removeCertification/{userId}")
    public ResponseEntity<AssignCertificationDTO> removeCertificationFromUser(@PathVariable UUID userId, @RequestParam UUID certificationID ){
        return ResponseEntity.ok(userServiceInterface.removeCertificationFromUser(userId, certificationID));
    }
    @PostMapping("updateUser")
    public ResponseEntity<Boolean> updateUserRole(@RequestBody UpdateUsersRoleDto requestDto){
        return ResponseEntity.ok(userServiceInterface.updateRole(requestDto));
    }
    @GetMapping("getUsersByRole/{roleId}")
    public ResponseEntity<List<UserDTO>> getUserByRole(@PathVariable UUID roleId){
        return ResponseEntity.ok(userServiceInterface.getUserByRoleId(roleId));
    }
    @GetMapping("getUsersByProject/{projectId}")
    public ResponseEntity<List<UserDTO>> getUserByProject(@PathVariable UUID projectId){
        return ResponseEntity.ok(userServiceInterface.getUserByProjectId(projectId));
    }
}