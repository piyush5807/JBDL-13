package com.example.jbdl13.demosecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(DemoSecurityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String peterEncodedPwd = bCryptPasswordEncoder.encode("peter123");
		String johnEncodedPwd = bCryptPasswordEncoder.encode("john123");
		String williamEncodedPwd = bCryptPasswordEncoder.encode("william123");

		logger.info("pwds are {}, {}, {}", peterEncodedPwd, johnEncodedPwd, williamEncodedPwd);

	}
}
