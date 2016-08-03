package br.unit.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unit.connectionfactory.ConnectionFactory;
import br.unit.entity.DadosPessoais;
import br.unit.repository.ProfessorRepository;

public class DadosPessoaisDAO extends GenericDAO<DadosPessoais> implements ProfessorRepository<DadosPessoais> , Serializable{

	private static final long serialVersionUID = 5216247596224934849L;
	private EntityManager em;
	
	@Override
	public DadosPessoais findByCPF(String cpf) {
		em = ConnectionFactory.geEntityManager();
		/*String query = "SELECT d FROM tb_dados_pessoais WHERE d.cpf = " + cpf;*/
		
		try {
			em.getTransaction().begin();
			/*String query = "select p from DadosPessoais p where p.cpf = " + cpf;*/
			/*Query result = em.createNamedQuery(query);*/
			Query cons = em.createQuery("select p from DadosPessoais p");
			List<DadosPessoais> dp = cons.getResultList();
			em.getTransaction().commit();
			DadosPessoais d = new DadosPessoais();
			for (DadosPessoais dadosP : dp) {
				if (dadosP.getCpf().equals(cpf)) {
					 d = dadosP;
					 return d;
				}
			}
			
			/*DadosPessoais dp = em.find(DadosPessoais.class, cpf);*/
			return null;		
			
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
