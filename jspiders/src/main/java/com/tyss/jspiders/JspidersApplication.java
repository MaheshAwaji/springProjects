package com.tyss.jspiders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tyss.jspiders.entity.Admin;
import com.tyss.jspiders.repository.AdminRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor       //create objects for final variables
@SpringBootApplication
public class JspidersApplication {
	
	//run method also creates database
	private final AdminRepository adminRepository;
	public static void main(String[] args) {
		SpringApplication.run(JspidersApplication.class, args);
	}
	@Bean
	public CommandLineRunner name() {
		return args -> {
			Admin admin = Admin.builder().userName("admin01").password("qwerty").build();
			adminRepository.save(admin);
			System.out.println("commandliner executed");
		};
	}

}
