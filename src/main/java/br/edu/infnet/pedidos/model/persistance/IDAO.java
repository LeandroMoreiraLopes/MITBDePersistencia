package br.edu.infnet.pedidos.model.persistance;

import java.util.List;

public interface IDAO<T> {

	//CRUD
	//Create
	Boolean salvar(T obj);

	//Retrieve all
	List<T> listarTodos();

	//Update
	Boolean atualizar(T obj);

	//Delete
	Boolean deletar(T obj);

	//Retrieve one
	T obter(Long codigo);

}