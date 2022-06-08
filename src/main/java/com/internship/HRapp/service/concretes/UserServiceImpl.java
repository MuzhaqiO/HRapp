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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

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
        userCreateDTO.setPassword(generateRandomPassword(10));
        System.out.println(userCreateDTO.getPassword());
        //sendRegistrationEmail(userCreateDTO);
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
    public static String generateRandomPassword(int len)
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
//    public void sendRegistrationEmail(UserCreateDTO userCreateDTO) {
//        SimpleMailMessage email = new SimpleMailMessage();
//        email.setTo(userCreateDTO.getEmail());
//        email.setSubject("Welcome to 3i Solution," + userCreateDTO.getFirstName() + "!");
//        email.setText("Text + username + password " + userCreateDTO.getUsername() + " \nPassword: " + userCreateDTO.getPassword());
//        email.setFrom("ibronazi@gmail.com");
//        JavaMailSender mailSender = new JavaMailSenderImpl();
//        mailSender.send(email);
//    }



   /* @Override
    public UserDTO updateUser(UUID userId, UserDTO userDTO) {
        Optional<User> user = usersRepo.findById(userId);
        return null;
    } */
}
