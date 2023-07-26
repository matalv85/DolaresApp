package dev.matias.DolaresApp;

import dev.matias.DolaresApp.model.Dolar;
import dev.matias.DolaresApp.model.User;
import dev.matias.DolaresApp.repository.DolarRepository;
import dev.matias.DolaresApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	/* 
	@Bean
	CommandLineRunner commandLineRunner(DolarRepository dolarRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {

			User user = new User("user", passwordEncoder.encode("password"), "ROLE_USER");
			User admin = new User("admin", passwordEncoder.encode("password"),"ROLE_USER,ROLE_ADMIN");
			userRepository.save(user);
			userRepository.save(admin);
			Dolar dolar = new Dolar("Dolar Oficial", 1.00, 1.00);
			dolar.setDate(LocalDate.now());
			dolarRepository.save(dolar);
			System.out.println(dolarRepository.findById(LocalDate.of(1004,11,11)));
			System.out.println(dolarRepository.findById(LocalDate.now()));
		};
	}
	*/

}
