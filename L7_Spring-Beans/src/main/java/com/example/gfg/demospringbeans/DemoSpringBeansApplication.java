package com.example.gfg.demospringbeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBeansApplication implements CommandLineRunner{

	private static Logger logger = LoggerFactory.getLogger(DemoSpringBeansApplication.class);

	@Autowired
	OtherController otherController;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBeansApplication.class, args);
		logger.info("Coming in main function");
//		otherController.testFunction();
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info("Coming in run function");
		otherController.testFunction();
	}

	public void test(){
		otherController.testFunction();
	}
}
