package com.mombesoft.tutorials.todobackendapi;

import com.mombesoft.tutorials.todobackendapi.dto.TodoDto;
import com.mombesoft.tutorials.todobackendapi.services.impl.TodoSvcImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class TodoBackentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoBackentApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDBData(TodoSvcImpl todoSvc) {
		return args -> {
			todoSvc.createTodo(
					TodoDto.builder().title("Finaliser la partie backend").build()
			);
		};
	}

}
