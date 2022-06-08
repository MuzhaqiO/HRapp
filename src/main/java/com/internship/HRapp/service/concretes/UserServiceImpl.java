package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.GenerateSecurePassword;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserServiceInterface, UserDetailsService {

    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepo userRepo;
    //private final JavaMailSender javaMailSender;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepo.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User by username " + username + " doesn't exist");
//        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());}

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
    public UserCreateDTO addNewUser(UserCreateDTO userCreateDTO) {
        userCreateDTO.setPassword(GenerateSecurePassword.generatePassword(8));
        sendRegistrationEmail(userCreateDTO);
//        encryptPassword(userCreateDTO);
        User createdUser = usersRepo.save(usersMapper.toEntity(userCreateDTO));
        return usersMapper.toDTO(createdUser);
    }

    @Override
    public void updateUser(@NotNull UserCreateDTO userCreateDTO) {
        User user = usersRepo.findUserByUserId(userCreateDTO.getUserId());
        user.setUsername(userCreateDTO.getUsername());
        user.setPassword(userCreateDTO.getPassword());
        user.setFirstName(user.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        user.setEmail(user.getEmail());
        user.setMobile(userCreateDTO.getMobile());
        user.setSecondContact(userCreateDTO.getSecondContact());
        user.setMobile(userCreateDTO.getMobile());
        usersRepo.save(user);
    }

    @Override
    public void updateUsersStatus(UserCreateDTO userCreateDTO) {
        User user = usersRepo.findUserByUserId(userCreateDTO.getUserId());
        user.setUsersStatus(userCreateDTO.getUsersStatus());
        usersRepo.save(user);
    }

//    @Override
//    public UserDTO editPassword(UUID Id, PasswordUpdate passwordUpdate) {
//        if (bCryptPasswordEncoder.matches(passwordUpdate.getOldPassword(),User.getPassword())){
//            User.setPassword(bCryptPasswordEncoder.encode(passwordUpdate.getNewPassword()));
//            usersRepo.save(passwordUpdate);
//        }
//    }

    public void sendRegistrationEmail(UserCreateDTO userCreateDTO) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(userCreateDTO.getEmail());
        email.setSubject("Welcome to 3i Solution," + userCreateDTO.getFirstName() + "!");
        email.setText("Text + username + password " + userCreateDTO.getUsername() + " \nPassword: " + userCreateDTO.getPassword());
        email.setFrom("3isolution@gmail.com");
        JavaMailSender mailSender = new JavaMailSenderImpl();
        mailSender.send(email);
    }


//    public void encryptPassword (UserCreateDTO userCreateDTO) {
//        userCreateDTO.setPassword(bCryptPasswordEncoder.encode(userCreateDTO.getPassword()));
//    }


}