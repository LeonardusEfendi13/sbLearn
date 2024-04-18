package com.project.sbLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class SbLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbLearnApplication.class, args);
	}

}
