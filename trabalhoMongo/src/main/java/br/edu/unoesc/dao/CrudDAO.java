package br.edu.unoesc.dao;

import java.util.List;

import br.edu.unoesc.model.Concurso;

public interface CrudDAO<T> {

	void inserir(T objeto);
	
	void alterar(T objeto);
	
	Concurso buscar(Long codigo);
	
	List<T> listar();
	
	void remover(Long codigo);
}	