package br.unit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unit.connectionfactory.ConnectionFactory;
import br.unit.repository.GenericRepository;

public abstract class GenericDAO<T> implements GenericRepository<T> {

	private EntityManager em;

	@Override
	public boolean save(T obj) {
		em = ConnectionFactory.geEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.getMessage();
		}

		return false;
	}

	@Override
	public boolean remover(T obj) {
		em = ConnectionFactory.geEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.getMessage();
		}
		return false;
	}

	@Override
	public T edit(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listAll() {
		em = ConnectionFactory.geEntityManager();
		
		try {
			em.getTransaction().begin();
			Query resul = em.createNamedQuery("select p from Projeto p");	
			List<T> lista = resul.getResultList();
			em.getTransaction().commit();
			return lista;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
