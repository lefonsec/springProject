package com.book.servicies;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.book.domain.Categoria;
import com.book.dto.CategoriaDTO;
import com.book.repository.CategoriaRepository;
import com.book.servicies.exception.DataException;
import com.book.servicies.exception.NotFoudException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new NotFoudException("Objeto não encontrado id: " + id));
	}

	public List<CategoriaDTO> findAll() {
		List<Categoria> lista = repository.findAll();
		return lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Long id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataException("obj não pode ser deletado, possui livros associados ");
		}
		
	}
}
