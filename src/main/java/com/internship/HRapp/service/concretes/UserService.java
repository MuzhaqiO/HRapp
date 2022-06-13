package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.projectsDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDTO.*;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.exceptions.NotFoundException;
import com.internship.HRapp.mapper.*;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
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
    private final ProjectsServiceInterface projectsService;
    private final ProjectsRepo projectsRepo;
    private final RoleMapper roleMapper;
    private final RoleRepo roleRepo;
    private final RoleServiceInterface roleService;
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
    public UserDTO updateUsersStatus(UUID userId, UsersStatusDTO usersStatusDTO) {
        User user = usersRepo.getById(userId);
        user.setUsersStatus(usersStatusDTO.getUsersStatus());
        return usersMapper.entityToDTO(usersRepo.save(user));
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
    public AssignRoleDTO assignRoleToUser(UUID userId, UUID roleId) {
        User user = usersRepo.getById(userId);
        Role role = roleMapper.toEntity(roleService.getRoleById(roleId));
        user.getRoles().add(role);
        usersRepo.save(user);
        return usersMapper.toDTOAssign(usersRepo.getById(userId));
    }

    @Override
        public UpdateRoleDTO removeRoleFromUser(UUID userId, UUID roleId){
        User user = usersRepo.getById(userId);
        user.getRoles().removeIf(role1 -> role1.getRoleId().equals(roleId));
        usersRepo.save(user);
        return usersMapper.toDTORole(usersRepo.getById(userId));
    }
    @Override
    public ProjectAssignDTO assignProjectToUser(UUID userId, UUID projectId) {
        User user = usersRepo.getById(userId);
        Projects project = projectsMapper.dtoToEntity(projectsService.getProjectById(projectId));
        user.getProjects().add(project);
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.getById(userId));
    }
    @Override
    public ProjectAssignDTO removeProjectFromUser(UUID userId, UUID projectId){
        User user = usersRepo.getById(userId);
        user.getProjects().removeIf(project -> project.getProjectId().equals(projectId));
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.getById(userId));
    }
    @Override
    public UpdateRoleDTO updateRole(UUID userId, UpdateUsersRoleDto usersRoleDto) {
            User user = usersRepo.getById(userId);
            Role existingRole = user.getRoles()
                    .stream()
                    .filter(role -> role.getRoleId().equals(usersRoleDto.getOldRoleId()))
                    .findAny().get();
            user.getRoles().remove(existingRole);
            Role newRole = roleMapper.toEntity(roleService.getRoleById(usersRoleDto.getNewRoleId()));
            user.getRoles().add(newRole);
            usersRepo.saveAndFlush(user);
            return usersMapper.toDTORole(usersRepo.getById(userId));
    }

    @Override
    public List<UserDTO> getUserByRoleId(UUID roleId) {
        return usersMapper.entitiesToDTOs(usersRepo.getUserByRolesRoleId(roleId));
    }

    @Override
    public List<UserDTO> getUserByProjectId(UUID projectId) {
        return usersMapper.entitiesToDTOs(usersRepo.getUserByProjectsProjectId(projectId));
    }
    //    @Override
//    public UpdateRoleDTO updateRole2(UUID userId, UpdateRoleDTO updateRoleDTO){
//        User user = usersRepo.getById(userId);
//        user.setRoles(roleMapper.toEntities(updateRoleDTO.getRoles()));
//        usersRepo.save(user);
//        return usersMapper.toDTORole(usersRepo.getById(userId));
//    }
//    i fshin te gjitha rolet dhe vensos te reja
}