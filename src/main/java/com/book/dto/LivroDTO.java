package com.book.dto;

import java.io.Serializable;

import com.book.domain.Livro;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	
	public LivroDTO(){
	}

	public LivroDTO(Livro obj) {
		super();
		id =obj.getId();
		titulo = obj.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
}
