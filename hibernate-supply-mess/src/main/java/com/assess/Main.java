package com.assess;

import java.util.List;

import com.assess.model.Supplier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class Main {
	public static void main(String[] args) {

		EntityManager em = EntityManagerFactoryProvider.getEntityManager();

		String objQuery = """
				SELECT s
				FROM Supplier s
				""";

		Query query = em.createQuery(objQuery);

		List<Supplier> allSupplier = query.getResultList();

		for(Supplier sup : allSupplier) {
			System.out.println(sup.getSname());
		}
		
		String hql = """
				SELECT s
				FROM Supplier s
				WHERE s.city = 'Delhi'
				""";
		query = em.createQuery(hql);
		List<Supplier> list = query.getResultList();

		for(Supplier s : list) {
		    System.out.println(s.getSname());
		}
		hql = """
				SELECT s.item.name
				FROM Supply s
				WHERE s.supplier.Sid = 1
				""";
		query = em.createQuery(hql);
		List<String> items = query.getResultList();

		for(String name : items) {
		    System.out.println(name);
		}
		em.close();
	}
}