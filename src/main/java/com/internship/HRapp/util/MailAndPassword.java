package com.internship.HRapp.util;

import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
@Service
@RequiredArgsConstructor
public class MailAndPassword {
    private final JavaMailSender mailSender;

    public String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    public void sendRegistrationEmail(UserCreateDTO userCreateDTO) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(userCreateDTO.getEmail());
        email.setSubject("Welcome to 3i Solution," + userCreateDTO.getFirstName() + "!");
        email.setText(" Password for " + " '" + userCreateDTO.getUsername() + "' "
                + " is: " + userCreateDTO.getPassword());
        email.setFrom("solutions3i@yahoo.com");
        mailSender.send(email);
    }
}
