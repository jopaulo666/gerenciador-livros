package com.jopaulo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jopaulo.livro.model.Livro;
import com.jopaulo.livros.repository.LivroRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jopaulo.livros.repository")
public class GerenciadorLivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorLivrosApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner (@Autowired LivroRepository repository) {
		return args -> {
			Livro livro = Livro.builder()
					.titulo("O Alquimista")
					.autor("Paulo Coelho")
					.descricao("De tempos em tempos, surge um livro capaz de mudar para sempre a vida de seus leitores."
							+ "O Alquimista é um deles. Com mais de 45 milhões de exemplares vendidos em todo o mundo, "
							+ "o mais famoso título de Paulo Coelho já se estabeleceu como um clássico moderno, atemporal e universal.").build();
			repository.save(livro);
					
		};
	}

}
