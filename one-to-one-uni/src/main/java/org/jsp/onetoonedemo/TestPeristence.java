package org.jsp.onetoonedemo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestPeristence {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		System.out.println(factory);

	}

}
