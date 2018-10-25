package com.finalso.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SoEntityManagerFactory {

	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory createEntityManagerFactory() {
		if(emf == null) {
			System.out.println("Trying to get session Factory");
			emf = Persistence.createEntityManagerFactory( "TestPersistence" );
			System.out.println("Session factory ok");
		}
		
		return emf;
		
	}

	
}
