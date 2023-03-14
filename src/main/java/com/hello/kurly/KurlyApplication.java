package com.hello.kurly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KurlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KurlyApplication.class, args);
	}

}
