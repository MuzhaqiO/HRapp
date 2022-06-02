package com.internship.HRapp;

import com.internship.HRapp.controller.UsersController;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.enumeration.TrustLevel;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.repository.UserRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class HRmanagementApplication{ //implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HRmanagementApplication.class, args);

	}

}
