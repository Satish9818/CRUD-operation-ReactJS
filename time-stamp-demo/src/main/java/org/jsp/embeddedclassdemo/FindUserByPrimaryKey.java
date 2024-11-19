package org.jsp.embeddedclassdemo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FindUserByPrimaryKey {
	public static void main(String[] args) {

		UserId userId = new UserId();
		userId.setEmail("abc@gmail.com");
		userId.setPhone(8886777);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		User u = manager.find(User.class, userId);

		if (u != null) {
			System.out.println("Phone Number: " + u.getUserId().getPhone());
			System.out.println("User Name: " + u.getName());
			System.out.println("Email ID: " + u.getUserId().getEmail());

		} else {
			System.err.println("Invalid Phone Number or Email ID");
		}
	}

}
