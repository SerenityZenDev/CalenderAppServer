package org.example.calenderappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CalenderAppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalenderAppServerApplication.class, args);
	}

}
