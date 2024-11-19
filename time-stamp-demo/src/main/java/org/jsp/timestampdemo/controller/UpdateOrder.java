package org.jsp.timestampdemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.timestampdemo.dto.FoodOrder;

public class UpdateOrder {
	public static void main(String[] args) {

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = manager.find(FoodOrder.class, 3);
		transaction.begin();
		order.setFood_item("biryani");
		transaction.commit();

	}
}
