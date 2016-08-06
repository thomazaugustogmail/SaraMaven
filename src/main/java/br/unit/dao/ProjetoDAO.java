package br.unit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unit.connectionfactory.ConnectionFactory;
import br.unit.entity.Projeto;
import br.unit.repository.ProjetoRepository;

public class ProjetoDAO extends GenericDAO<Projeto> implements ProjetoRepository<Projeto> {

	private EntityManager em;

	public Projeto findById(long id){
		em = ConnectionFactory.geEntityManager();		
		
		Projeto p = em.find(Projeto.class, id);
		em.close();
		
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listaTodos(){
		em = ConnectionFactory.geEntityManager();		
		try {
			em.getTransaction().begin();
			Query cons = em.createQuery("select p from Projeto p");
			List<Projeto> p = cons.getResultList();
			em.getTransaction().commit();
			
			return p;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> projetoByProf(String cpf){
		em = ConnectionFactory.geEntityManager();
		
		try {
			em.getTransaction().begin();
			Query resul = em.createQuery("select p from Projeto p");
			List<Projeto> todosProj = resul.getResultList();
			em.getTransaction().commit();
			List<Projeto> projetoProf = new ArrayList<Projeto>();
			for (Projeto pro : todosProj) {
				if (pro != null && pro.getCpf().equals(cpf)) {
					projetoProf.add(pro);
				}
			}
			if (projetoProf != null) 
				return projetoProf;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	/* DadosPessoais dp = em.find(DadosPessoais.class, cpf); */

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}