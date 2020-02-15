package it.unisalento.myairbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MyAirBnBApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAirBnBApplication.class, args);
	}

}
