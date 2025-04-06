package com.code.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import com.code.entity.Role;
import com.code.entity.Users;

public class CreateUsers {
	private SessionFactory sessionFactory = null;

	public CreateUsers(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// Create Users
		Users u1 = new Users("Raman Bharadwaj", "secure467", "Bhar89@gmail.com", Role.CUSTOMER);
		Users u2 = new Users("Shristi Das", "kijh467", "Das805@gmail.com", Role.ADMIN);

		// Save Users
		  try {
	            session.persist(u1);
	        } catch (ConstraintViolationException e) {
	            System.out.println("Duplicate user (Raman Bharadwaj). Not inserted.");
	        }

	        try {
	            session.persist(u2);
	        } catch (ConstraintViolationException e) {
	            System.out.println("Duplicate user (Shristi Das). Not inserted.");
	        }

		System.out.println("User inserted successfully with 1st ID: " + u1.getId());
		System.out.println("User inserted successfully with 2nd ID: " + u2.getId());

		session.getTransaction().commit();
		session.close();
	}
}
