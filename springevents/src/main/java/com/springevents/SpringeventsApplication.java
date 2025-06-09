package com.springevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringeventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringeventsApplication.class, args);
	}

}
