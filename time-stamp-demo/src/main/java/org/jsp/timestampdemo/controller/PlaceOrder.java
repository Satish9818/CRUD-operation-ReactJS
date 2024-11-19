package org.jsp.timestampdemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.timestampdemo.dto.FoodOrder;

public class PlaceOrder {

	public static void main(String[] args) {

		FoodOrder order = new FoodOrder();
		order.setAddress("JP nagar");
		order.setFood_item("Thakali Set");
		order.setCost(550);

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(order);
		transaction.begin();
		transaction.commit();
		System.out.println("Order Placed with ID: " + order.getId());
	}
}
