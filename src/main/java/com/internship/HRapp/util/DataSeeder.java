//package com.internship.HRapp.util;
//
//import com.internship.HRapp.entity.User;
//import com.internship.HRapp.repository.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//@RequiredArgsConstructor
//public class DataSeeder implements CommandLineRunner {
//    private final PasswordEncoder passwordEncoder;
//    private final UserRepo userRepo;
//
////    @EventListener
////    public void seed(ContextRefreshedEvent event) {
////        seedUsersTable();
////    }
////
////    private void seedUsersTable() {
////
////    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        var existingUser = userRepo.findAll();
//
//        if (existingUser == null || existingUser.size() <= 0) {
//            User user = new User();
//            user.setFirstName("First");
//            user.setUsername("theFirst");
//            user.setEmail("test@test.com");
//            user.setPassword(passwordEncoder.encode("password"));
//            userRepo.save(user);
//        }
//    }
//}
