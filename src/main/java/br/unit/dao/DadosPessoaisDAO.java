package br.unit.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unit.connectionfactory.ConnectionFactory;
import br.unit.entity.DadosPessoais;
import br.unit.repository.ProfessorRepository;

public class DadosPessoaisDAO extends GenericDAO<DadosPessoais>
		implements ProfessorRepository<DadosPessoais>, Serializable {

	private static final long serialVersionUID = 5216247596224934849L;
	private EntityManager em;

	@Override
	public DadosPessoais findByCPF(String cpf) {
		em = ConnectionFactory.geEntityManager();
		/*
		 * String query = "SELECT d FROM tb_dados_pessoais WHERE d.cpf = " +
		 * cpf;
		 */
		DadosPessoais dp = null;
		try {
			em.getTransaction().begin();

			dp = em.find(DadosPessoais.class, cpf);
			em.close();

		} catch (Exception e) {
			e.getMessage();
		}
		return dp;
	}

	public DadosPessoais findById(long id) {
		em = ConnectionFactory.geEntityManager();

		DadosPessoais dp = null;
		try {
			em.getTransaction().begin();
			dp = em.find(DadosPessoais.class, id);
			em.close();
			return dp;
		} catch (Exception e) {
			e.getMessage();
		}
		return dp;
	}
	
	@SuppressWarnings("unchecked")
	public List<DadosPessoais> listByTipo(long tipo){
		em = ConnectionFactory.geEntityManager();
		
		List<DadosPessoais> lista = null;
		try {
			em.getTransaction().begin();
			Query resul = em.createQuery("select d from DadosPessoais d ");
			lista = resul.getResultList();
			em.getTransaction().commit();
			List<DadosPessoais> dpLista = new ArrayList<DadosPessoais>();
			for (DadosPessoais dp : lista) {
				if (dp.getTipo() == tipo) {
					dpLista.add(dp);
				}
			}
		
			return dpLista;
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
