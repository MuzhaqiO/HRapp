package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.certificationDto.AssignCertificationDTO;
import com.internship.HRapp.dto.educationDto.AssignEducationDTO;
import com.internship.HRapp.dto.experiencesDTO.AssignExperiencesDTO;
import com.internship.HRapp.dto.personalfileDto.AssignPersonalFileDTO;
import com.internship.HRapp.dto.projectsDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDTO.*;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.exceptions.NotFoundException;
import com.internship.HRapp.mapper.*;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
    private final ProjectsMapper projectsMapper;
    private final RoleMapper roleMapper;
    private final RoleRepo roleRepo;
    private final ProjectsRepo projectsRepo;
    private final PersonalFileMapper personalFileMapper;
    private final ExperiencesMapper experiencesMapper;
    private final EducationMapper educationMapper;
    private final CertificationMapper certificationMapper;


    @Override
    public UserDTO getUserById(UUID userId) {
        return usersMapper.entityToDTO(usersRepo.getById(userId));
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        boolean exists = usersRepo.existsByUsername(username);
        if (!exists){
            throw new NotFoundException();
        }
        return usersMapper.entityToDTO(usersRepo.getByUsername(username));
    }

    @Override
    public List<UserDTO> getUsers() {
        return usersMapper.entitiesToDTOs(usersRepo.findAll());
    }

    @Override
    public UserCreateDTO addNewUser(UserCreateDTO userCreateDTO) {
        User createdUser = usersRepo.save(usersMapper.toEntity(userCreateDTO));
        return usersMapper.toDTO(createdUser);
    }

    @Override
    public UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO) {
        User user = usersMapper.toEntityUpdate(userUpdateDTO);
        usersRepo.save(user);
        return usersMapper.toDTOUpdate(user);
    }

    @Override
    public UsersStatusDTO updateUsersStatus(UUID userId, UsersStatusDTO usersStatusDTO) {
        User user = usersRepo.getById(userId);
        user.setUsersStatus(usersStatusDTO.getUsersStatus());
        return usersMapper.toDTOStatus(usersRepo.save(user));
    }

    @Override
    public UsernameDTO updateUsername(UUID userId, UsernameDTO usernameDTO) {
        User user = usersRepo.getById(userId);
        user.setUsername(usernameDTO.getUsername());
        return usersMapper.toDTOUsername(usersRepo.save(user));
    }

    @Override
    public PasswordDTO updatePassword(UUID userId, PasswordDTO passwordDTO) {
        User user = usersRepo.getById(userId);
        user.setPassword(passwordDTO.getPassword());
        return usersMapper.toDTOPassword(usersRepo.save(user));
    }

    @Override
    public AssignRoleDTO assignRoleToUser(UUID userId, AssignRoleDTO assignRoleDTO) {
        User user = usersRepo.getById(userId);
        user.getRoles().addAll(roleMapper.toEntities(assignRoleDTO.getRoles()));
        usersRepo.save(user);
        return usersMapper.toDTOAssign(usersRepo.findUserByUserId(userId));
    }

    @Override
        public UpdateRoleDTO removeRoleFromUser(UUID userId, UUID roleId){
        User user = usersRepo.getById(userId);
        user.getRoles().removeIf(role1 -> role1.getRoleId().equals(roleId));
        usersRepo.save(user);
        return usersMapper.toDTORole(usersRepo.getById(userId));
    }
    @Override
    public AssignPersonalFileDTO assignPersonalFileToUser(UUID userId, AssignPersonalFileDTO assignPersonalFileDTO) {
        User user = usersRepo.getById(userId);
        user.getPersonalFiles().addAll(personalFileMapper.toModel(assignPersonalFileDTO.getPersonalFiles()));
        usersRepo.save(user);
        return usersMapper.toDTOPersonalFile(usersRepo.findUserByUserId(userId));
    }
    @Override
    public AssignPersonalFileDTO removePersonalFileFromUser(UUID userId, UUID personalFileId){
        User user = usersRepo.getById(userId);
        user.getPersonalFiles().removeIf(personalFile -> personalFile.getPersonalFileId().equals(personalFileId));
        usersRepo.save(user);
        return usersMapper.toDTOPersonalFile(usersRepo.getById(userId));
    }
    @Override
    public ProjectAssignDTO assignProjectToUser(UUID userId, ProjectAssignDTO projectAssignDTO) {
        User user = usersRepo.getById(userId);
        user.getProjects().addAll(projectsMapper.toEntities(projectAssignDTO.getProjects()));
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.findUserByUserId(userId));
    }
    @Override
    public ProjectAssignDTO removeProjectFromUser(UUID userId, UUID projectId){
        User user = usersRepo.getById(userId);
        user.getProjects().removeIf(project -> project.getProjectId().equals(projectId));
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.getById(userId));
    }
    @Override
    public AssignExperiencesDTO assignExperienceToUser(UUID userId, AssignExperiencesDTO assignExperiencesDTO) {
        User user = usersRepo.getById(userId);
        user.getExperiences().addAll(experiencesMapper.DTOToEntities(assignExperiencesDTO.getExperiences()));
        usersRepo.save(user);
        return usersMapper.toDTOExperience(usersRepo.findUserByUserId(userId));
    }
    @Override
    public AssignExperiencesDTO removeExperienceFromUser(UUID userId, UUID expId){
        User user = usersRepo.getById(userId);
        user.getExperiences().removeIf(experience -> experience.getExpId().equals(expId));
        usersRepo.save(user);
        return usersMapper.toDTOExperience(usersRepo.getById(userId));
    }
    @Override
    public AssignEducationDTO assignEducationToUser(UUID userId, AssignEducationDTO assignEducationDTO) {
        User user = usersRepo.getById(userId);
        user.getEducations().addAll(educationMapper.toModel(assignEducationDTO.getEducations()));
        usersRepo.save(user);
        return usersMapper.toDTOEducation(usersRepo.findUserByUserId(userId));
    }
    @Override
    public AssignEducationDTO removeEducationFromUser(UUID userId, UUID educationId){
        User user = usersRepo.getById(userId);
        user.getEducations().removeIf(education -> education.getEducationId().equals(educationId));
        usersRepo.save(user);
        return usersMapper.toDTOEducation(usersRepo.getById(userId));
    }
    @Override
    public AssignCertificationDTO assignCertificationToUser(UUID userId, AssignCertificationDTO assignCertificationDTO) {
        User user = usersRepo.getById(userId);
        user.getCertifications().addAll(certificationMapper.toModel(assignCertificationDTO.getCertifications()));
        usersRepo.save(user);
        return usersMapper.toDTOCertification(usersRepo.findUserByUserId(userId));
    }
    @Override
    public AssignCertificationDTO removeCertificationFromUser(UUID userId, UUID certificationID){
        User user = usersRepo.getById(userId);
        user.getCertifications().removeIf(certification -> certification.getCertificationID().equals(certificationID));
        usersRepo.save(user);
        return usersMapper.toDTOCertification(usersRepo.getById(userId));
    }

//    @Override
//    public UpdateRoleDTO updateRole2(UUID userId, UpdateRoleDTO updateRoleDTO){
//        User user = usersRepo.getById(userId);
//        user.setRoles(roleMapper.toEntities(updateRoleDTO.getRoles()));
//        usersRepo.save(user);
//        return usersMapper.toDTORole(usersRepo.getById(userId));
//    }
//    i fshin te gjitha rolet dhe vensos te reja

    @Override
    public Boolean updateRole(UpdateUsersRoleDto usersRoleDto) {
        try
        {
        User user = usersRepo.getById(usersRoleDto.getUserId());
        Role existingRole = user.getRoles()
                .stream()
                .filter(role -> role.getRoleId().equals(usersRoleDto.getOldRoleId()))
                .findAny().get();
        user.getRoles().remove(existingRole);
        Role newRole = roleRepo.getById(usersRoleDto.getNewRoleId());
        user.getRoles().add(newRole);
        usersRepo.saveAndFlush(user);
        return user.getRoles().stream().anyMatch(role -> role.getRoleId().equals(usersRoleDto.getNewRoleId()));
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<UserDTO> getUserByRoleId(UUID roleId) {
        boolean exists = roleRepo.existsById(roleId);
        if (!exists) {
            throw new IllegalStateException(
                    "Role with id " + roleId + " does not exist");
        }
        return usersMapper.entitiesToDTOs(usersRepo.getUserByRolesRoleId(roleId));
    }

    @Override
    public List<UserDTO> getUserByProjectId(UUID projectId) {
        boolean exists = projectsRepo.existsById(projectId);
        if (!exists) {
            throw new IllegalStateException(
                    "Project with id " + projectId + " does not exist");
        }
        return usersMapper.entitiesToDTOs(usersRepo.getUserByProjectsProjectId(projectId));
    }
}