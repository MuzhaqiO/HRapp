package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.dto.userDTO.UsersStatusDTO;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface, UserDetailsService {

    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User by username "+username+ " doesn't exist");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));});
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
    @Override
    public UserDTO getUserById(UUID userId) {
        return usersMapper.entityToDTO(usersRepo.getById(userId));
    }
    @Override
    public UserDTO getUserByUsername(String username) {
        return usersMapper.entityToDTO(usersRepo.getByUsername(username));
    }
    @Override
    public List<UserDTO> getUsers() {
        return usersMapper.entitiesToDTOs(usersRepo.findAll());
    }

    @Override
    public void assignRole(AssignRoleDTO assignRoleDTO) {
        User user = usersRepo.findUserByUserId(assignRoleDTO.getUserId());
        Role role = roleRepo.findRoleByRoleId(assignRoleDTO.getRoleId());
        user.getRoles().add(role);
    }

    @Override
    public UserCreateDTO addNewUser(UserCreateDTO userCreateDTO) {
        userCreateDTO.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        User createdUser = usersRepo.save(usersMapper.toEntity(userCreateDTO));
        return usersMapper.toDTO(createdUser);
    }
    @Override
    public void updateUser(UserCreateDTO userCreateDTO) {
    User user = usersRepo.findUserByUserId(userCreateDTO.getUserId());
    user.setUsername(userCreateDTO.getUsername());
    user.setPassword(userCreateDTO.getPassword());
    user.setFirstName(userCreateDTO.getFirstName());
    user.setLastName(userCreateDTO.getLastName());
    user.setEmail(userCreateDTO.getEmail());
    user.setMobile(userCreateDTO.getMobile());
    user.setSecondContact(userCreateDTO.getSecondContact());
        usersRepo.save(user);
    }
    @Override
    public void updateUsersStatus(UsersStatusDTO usersStatusDTO) {
     User user = usersRepo.findUserByUserId(usersStatusDTO.getUserId());
     user.setUsersStatus(usersStatusDTO.getUsersStatus());
     usersRepo.save(user);
    }



   /* @Override
    public UserDTO updateUser(UUID userId, UserDTO userDTO) {
        Optional<User> user = usersRepo.findById(userId);
        return null;
    } */
}
