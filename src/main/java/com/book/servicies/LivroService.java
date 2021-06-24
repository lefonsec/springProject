package com.book.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.domain.Categoria;
import com.book.domain.Livro;
import com.book.repository.LivroRepository;
import com.book.servicies.exception.NotFoudException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new NotFoudException("Obj não encontrado " + id));
	}

	public List<Livro> findAll(Long id_cat) {
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Long id, Livro obj) {
		Livro newObj = findById(id);
		updateDate(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateDate(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNomeAutor(obj.getNomeAutor());
		newObj.setTexto(obj.getTexto());

	}

	public Livro create(Long id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}

	public void delete(Long id) {
		Livro obj = findById(id);
		livroRepository.delete(obj);

	}

}
