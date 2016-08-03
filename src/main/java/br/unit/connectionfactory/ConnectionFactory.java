package br.unit.connectionfactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SaraMaven");
	
	public static EntityManager geEntityManager(){
		return emf.createEntityManager();
	}

}
