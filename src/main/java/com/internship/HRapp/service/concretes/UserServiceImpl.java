package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.projectDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.ProjectsMapper;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.security.MyUserDetails;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import com.internship.HRapp.util.JwtUtil;
import com.internship.HRapp.util.MailAndPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;
import java.io.NotActiveException;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
    private final ProjectsMapper projectsMapper;
    private final ProjectsRepo projectsRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private final MyUserDetails myUserDetails;
    private final MailAndPassword mailAndPassword;

    @Override
    public UserCreateDTO getUserById(UUID userId) {
        return usersMapper.toDTO(usersRepo.getById(userId));
    }
    @Override
    public UserCreateDTO getUserProfile(UUID userId) {
        return usersMapper.toDTO(usersRepo.getById(userId));
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
        userCreateDTO.setPassword(mailAndPassword.generateRandomPassword(10));
        System.out.println(userCreateDTO.getPassword());
        mailAndPassword.sendRegistrationEmail(userCreateDTO);
        userCreateDTO.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        User createdUser = usersRepo.save(usersMapper.toEntity(userCreateDTO));

        return usersMapper.toDTO(createdUser);
    }
    @Override
    public void updateUser(@NotNull UserCreateDTO userCreateDTO) {
    User user = usersRepo.findUserByUserId(userCreateDTO.getUserId());
    user.setUsername(userCreateDTO.getUsername());
    user.setPassword(userCreateDTO.getPassword());
    user.setFirstName(userCreateDTO.getFirstName());
    user.setLastName(userCreateDTO.getLastName());
    user.setEmail(userCreateDTO.getEmail());
    user.setSecondContact(userCreateDTO.getSecondContact());
    user.setMobile(userCreateDTO.getMobile());
    user.setMobile(userCreateDTO.getMobile());
    //user.setProjects(projectsMapper.toEntities(userCreateDTO.getProjects()));
        usersRepo.save(user);
    }
    @Override
    public void updateUserDTO(@NotNull UserDTO userDTO) {
        User user = usersRepo.findUserByUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        //user.setProjects(projectsMapper.toEntities(userCreateDTO.getProjects()));
        usersRepo.save(user);
    }

    @Override
    public void updateUsersStatus(UsersStatusDTO usersStatusDTO) {
     User user = usersRepo.findUserByUserId(usersStatusDTO.getUserId());
     user.setUsersStatus(usersStatusDTO.getUsersStatus());
     usersRepo.save(user);
    }

    @Override
    public void updateUserByUsername(@NotNull UserDTO userDTO) {
        User user = usersRepo.findByUsername(userDTO.getUsername());
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        //user.setProjects(projectsMapper.toEntities(userCreateDTO.getProjects()));
        usersRepo.save(user);
    }

    @Override
    public ProjectAssignDTO assignProjectToUser(UUID userId, UUID projectId) {
        User user = usersRepo.getById(userId);
        user.getProjects().add(projectsRepo.getById(projectId));
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.findUserByUserId(userId));
    }
   /* @Override
    public UserDTO updateUser(UUID userId, UserDTO userDTO) {
        Optional<User> user = usersRepo.findById(userId);
        return null;
    } */

//    public static String generateRandomPassword(int len) {
//        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        SecureRandom random = new SecureRandom();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < len; i++) {
//            int randomIndex = random.nextInt(chars.length());
//            sb.append(chars.charAt(randomIndex));
//        }
//        return sb.toString();
//    }
//
//    public void sendRegistrationEmail(UserCreateDTO userCreateDTO) {
//        SimpleMailMessage email = new SimpleMailMessage();
//        email.setTo(userCreateDTO.getEmail());
//        email.setSubject("Welcome to 3i Solution," + userCreateDTO.getFirstName() + "!");
//        email.setText("Text + username + password " + userCreateDTO.getUsername() + " \nPassword: " + userCreateDTO.getPassword());
//        email.setFrom("naziibro33@yahoo.com");
//        mailSender.send(email);
//    }
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
        }else throw new IllegalStateException("Password should have 8 or more characters");

    }

    @Override
    public List<UserDTO> getUserByProjectId(UUID projectId) {
        return usersMapper.entitiesToDTOs(usersRepo.getUserByProjectsProjectId(projectId));
    }

    @Override
    public String deleteUserByUserId(UUID userId) {
        usersRepo.deleteById(userId);
        return "User {id} has been deleted"+userId;
    }

}
