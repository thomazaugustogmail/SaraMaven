package br.unit.repository;

import java.util.List;

public interface GenericRepository<T> {

	public boolean save(T obj);
	public boolean remover(T obj);
	public T edit (long id);
	public List<T> listAll() ;
	
}
