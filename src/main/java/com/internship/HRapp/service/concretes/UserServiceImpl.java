package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl {

    @Autowired
    private final UserRepo usersRepo;
    @Autowired
    private final UserMapper usersMapper;
    @Autowired
    private final RoleRepo roleRepo;
    @Autowired
    private final ProjectsRepo projectsRepo;

    public UserDTO getUserById(UUID userId) {
        boolean exists = usersRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exist");
        }
        return usersMapper.entityToDTO(usersRepo.getById(userId));
    }

    public UserDTO getUserByUsername(String username) {
        return usersMapper.entityToDTO(usersRepo.getByUsername(username));
    }

    public List<UserDTO> getUsers() {
        return usersMapper.entitiesToDTOs(usersRepo.findAll());
    }

    public UserCreateDTO addNewUser(UserCreateDTO userCreateDTO) {
        User createdUser = usersRepo.save(usersMapper.toEntity(userCreateDTO));
        return usersMapper.toDTO(createdUser);
    }

    public UserCreateDTO updateUser(UserCreateDTO userCreateDTO) {
        User user = usersMapper.toEntity(userCreateDTO);
        usersRepo.save(user);
        return usersMapper.toDTO(user);
    }

    public UsersStatusDTO updateUsersStatus(UUID userId, UsersStatusDTO usersStatusDTO) {
        User user = usersRepo.getById(userId);
        user.setUsersStatus(usersStatusDTO.getUsersStatus());
        usersRepo.save(user);
        return usersMapper.toDTOStatus(user);
    }

    public AssignRoleDTO assignRoleToUser(UUID userId, AssignRoleDTO assignRoleDTO) {
        User user = usersRepo.getById(userId);
        Role role = roleRepo.findRoleByRoleId(assignRoleDTO.getRoleId());
        user.getRoles().add(role);
        usersRepo.save(user);
        return usersMapper.toDTOAssign(usersRepo.getById(userId));
    }

    //    public AssignRoleDTO removeRoleFromUser(AssignRoleDTO assignRoleDTO){
//        User user = usersRepo.findUserByUserId(assignRoleDTO.getUserId());
//        Role role = roleRepo.findRoleByRoleId(assignRoleDTO.getRoleId());
//        user.getRoles().remove(role);
//        usersRepo.save(user);
//        return usersMapper.toDTOAssign(usersRepo.getById(user.getUserId()));
//    }
    public ProjectAssignDTO assignProjectToUser(UUID userId, ProjectAssignDTO projectAssignDTO) {
        User user = usersRepo.getById(userId);
        Projects projects = projectsRepo.findProjectByProjectId(projectAssignDTO.getProjectId());
        user.getProjects().add(projects);
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.getById(userId));
    }
}