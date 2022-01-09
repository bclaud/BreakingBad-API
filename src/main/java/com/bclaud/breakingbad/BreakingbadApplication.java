package com.bclaud.breakingbad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BreakingbadApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreakingbadApplication.class, args);
	}

}
