package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	/*We are testing the application here, in big scale projects we can call our method from different places*/
	@Bean
	public ApplicationRunner runner(Publisher p){
		return args -> {
			p.sendMessage("Hello");
		};
	}

}
