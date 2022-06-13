package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.security.MyUserDetails;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import com.internship.HRapp.util.JwtUtil;
import com.internship.HRapp.util.MailAndPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {
    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private final MyUserDetails myUserDetails;
    private final MailAndPassword mailAndPassword;

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
        userCreateDTO.setPassword(mailAndPassword.generateRandomPassword(10));
        System.out.println(userCreateDTO.getPassword());
        mailAndPassword.sendRegistrationEmail(userCreateDTO);
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

    @Override
    public AuthResponseDTO login(UserLoginDTO loginDTO) throws Exception {
        User user = usersRepo.getByUsername(loginDTO.getUsername());
        if (user.getUsersStatus()) {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
                );
            } catch (BadCredentialsException e) {
                throw new Exception("Incorrect username or password", e);
            }
            final UserDetails userDetails = myUserDetails
                    .loadUserByUsername(loginDTO.getUsername());
            final String jwt = jwtTokenUtil.generateToken(userDetails);
            return new AuthResponseDTO(jwt);
        }
        throw new NotActiveException("This user is not active");
    }

    @Override
    public void changePassword(PasswordDTO passwordUpdate) {
        User user = usersRepo.getById(passwordUpdate.getUserId());
        if (passwordUpdate.getNewPassword().length() >= 8) {
            if (passwordEncoder.matches(passwordUpdate.getOldPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(passwordUpdate.getNewPassword()));
                usersRepo.save(user);
            }
        } else throw new IllegalStateException("Password should have 8 or more characters");

    }
}
