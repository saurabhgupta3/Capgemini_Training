package com.assess;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null || !emf.isOpen()) {
			Map<String, Object> props = new HashMap<>();

	        // Read password from environment variable
	        props.put("jakarta.persistence.jdbc.password",
	                  System.getenv("DB_PASSWORD"));

	        emf = Persistence.createEntityManagerFactory("supply_db_pu", props);
		}
		System.out.println(emf);
		return emf;

	}

	public static EntityManager getEntityManager() {
		if (emf == null)
			getEntityManagerFactory();
		if (em == null || !em.isOpen())
			em = emf.createEntityManager();
		return em;
	}

	public static void closeConnections() {
		getEntityManager().close();
		getEntityManagerFactory().close();
	}
}
