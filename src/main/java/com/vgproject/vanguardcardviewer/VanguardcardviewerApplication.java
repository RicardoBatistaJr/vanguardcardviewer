package com.vgproject.vanguardcardviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class VanguardcardviewerApplication {
	public static void main(String[] args) {
		SpringApplication.run(VanguardcardviewerApplication.class, args);
	}
}
