package com.internship.HRapp;

import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.entity.Users;
import com.internship.HRapp.enumeration.TrustLevel;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.repository.UsersRepo;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HRmanagementApplication{ //implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HRmanagementApplication.class, args);
	}

	/*private ExperiencesRepo experiencesRepo;

	private UsersRepo usersRepo;
	@Override
	public void run(String... args) throws Exception {
		Experiences experiences = new Experiences();
		experiences.setCompany("Facebook");
		experiences.setPositions("Manager");
		experiences.setStartTime(2022,01,01);
		experiences.setEndTime(2022,02,02);
		experiences.setTrustLevel(TrustLevel.LOW_TRUST);
		experiencesRepo.save(experiences);

		Users users1 = new Users();
		users1.setFirstName("Arian");
		users1.setLastName("Dushi");
		users1.setEmail("ariandushi000@gmail.com");
		users1.setPassword("sekret");
		users1.setExperiences((List<Experiences>) experiences);
		usersRepo.save(users1);

		Users users2 = new Users();
		users1.setFirstName("Nazi");
		users1.setLastName("Ibro");
		users1.setEmail("naziibro@gmail.com");
		users1.setPassword("sekret2");
		users1.setExperiences((List<Experiences>) experiences);
		usersRepo.save(users2);

	}*/
}
