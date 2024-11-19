package org.jsp.onetomanybi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.dto.Merchant;
import org.jsp.onetomanybi.dto.Product;

public class SaveMerchantAndProducts {

	public static void main(String[] args) {
		Merchant m = new Merchant();
		m.setGst_number("ABCD12345");
		m.setName("ABCD");
		m.setPhone(777881L);
		m.setPassword("abc123");

		Product p1 = new Product();
		p1.setBrand("electronics");
		p1.setCost(1231);
		p1.setName("Smartphone");
		p1.setMerchant(m);

		Product p2 = new Product();
		p2.setBrand("electronics");
		p2.setCost(1231);
		p2.setName("Laptop");
		p2.setMerchant(m);

		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		m.setProducts(products);

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(m);
		transaction.begin();
		transaction.commit();
	}
}
