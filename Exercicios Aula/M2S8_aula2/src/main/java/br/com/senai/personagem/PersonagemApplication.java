package br.com.senai.personagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
	"br.com.senai.personagem.model"
	})
@EnableJpaRepositories(basePackages = {
	"br.com.senai.personagem.repository"
	})
public class PersonagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonagemApplication.class, args);
	}
}