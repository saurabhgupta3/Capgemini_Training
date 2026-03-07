package com.gal;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		EntityManagerFactory emf = getEntityManagerFactory();
		System.out.println(emf);
		
		em.getTransaction().begin();
		Project pr1 = new Project(0, Date.valueOf("2020-04-12"), Date.valueOf("2030-05-08"), )
		
		close();
	}
	
	public static void close() {
		getEntityManager().close();
		getEntityManagerFactory().close();
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null || !emf.isOpen()) {
			Map<String, Object> props = new HashMap<>();

	        // Read password from environment variable
	        props.put("jakarta.persistence.jdbc.password",
	                  System.getenv("DB_PASSWORD"));

	        emf = Persistence.createEntityManagerFactory("company_db_pu", props);
		}
		
		System.out.println(emf);
		return emf;
	}

	public static EntityManager getEntityManager() {
		if (emf == null) getEntityManagerFactory();
		
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
		System.out.println(em);
		return em;
	}
}
