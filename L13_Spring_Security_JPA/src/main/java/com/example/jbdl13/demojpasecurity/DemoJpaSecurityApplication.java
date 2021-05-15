package com.example.jbdl13.demojpasecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoJpaSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaSecurityApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		MyUser user1 = MyUser.builder()
				.username("john")
				.password(encoder.encode("john123"))
				.authorities("PERSON")
				.build();

		MyUser user2 = MyUser.builder()
				.username("peter")
				.password(encoder.encode("peter123"))
				.authorities("PERSON_ADMIN")
				.build();

		MyUser user3 = MyUser.builder()
				.username("william")
				.password(encoder.encode("william123"))
				.authorities("PERSON_ADMIN:PERSON")
				.build();

		userRepository.saveAll(Arrays.asList(user1, user2, user3));

	}
}
