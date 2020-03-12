package com.nu75h311.creditcheckservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding(Source.class) // to bind Rabbit to the Source class
public class CreditCheckServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCheckServiceApplication.class, args);
	}

}
