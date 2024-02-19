package com.nhnacademy.edu.springboot.springBootStudent;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class SpringBootStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentApplication.class, args);
//		SpringApplication application = new SpringApplication(SpringBootStudentApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
	}

}
