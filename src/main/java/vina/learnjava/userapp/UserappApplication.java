package vina.learnjava.userapp;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import vina.learnjava.userapp.model.User;
import vina.learnjava.userapp.service.UserRepository;

@SpringBootApplication
public class UserappApplication {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserappApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init() {
        return args -> {
            Stream.of("Vinay", "Kumar", "Raja", "Ravi", "Arun","Yadav").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@gmail.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
