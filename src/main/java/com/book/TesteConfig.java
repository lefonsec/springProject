package com.book;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.book.domain.Categoria;
import com.book.domain.Livro;
import com.book.repository.CategoriaRepository;
import com.book.repository.LivroRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new  Categoria(null,"Informática","Livros de ti");
		Livro l1 = new Livro(null,"Clean code","Robert Martson","Lorem ipsum", cat1);
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1));
		livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
