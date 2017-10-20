package com.cookcollab.data;

import com.cookcollab.data.entity.Event;
import com.cookcollab.data.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;


public class DatabaseTest {


	@Test
	public void userDatabaseTest(){
		
		try(SessionFactory sessionFactory = new Configuration().configure()
			                                               .addAnnotatedClass(User.class)
			                                               .addAnnotatedClass(Event.class)
			                                               .buildSessionFactory();) {

			System.out.println("Creating a User on Database");
			User testUser = new User();

			testUser.setBio("Test Bio");
			testUser.setEmail("test@test.com");
			testUser.setLastName("Ever");
			testUser.setFirstName("GreaTEST");
			testUser.setPhone("(123) 456-7890");

			create(testUser, sessionFactory.getCurrentSession());

			System.out.println("Reading User from Database");

			User databaseUser = read(User.class, testUser.getUserID(), sessionFactory.getCurrentSession());

			assertTrue("Phone number not properly stored/updated on database; "
							+ "expected (123) 456-7890, got " + databaseUser.getPhone(),
					databaseUser.getPhone().equals("(123) 456-7890"));

			System.out.println("Updating User on Database");

			testUser.setPhone("(555) 867-5309");

			update(testUser, sessionFactory.getCurrentSession());

			databaseUser = read(User.class, testUser.getUserID(), sessionFactory.getCurrentSession());

			assertTrue("Phone number not properly stored/updated on database; "
				   + "expected (555) 867-5309, got " + databaseUser.getPhone(),
				   databaseUser.getPhone().equals("(555) 867-5309"));

			System.out.println("Deleting User from Databse");

			delete(databaseUser, sessionFactory.getCurrentSession());

			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			assertTrue("User not deleted from database",
					   !session.contains(databaseUser));

			session.getTransaction().commit();

		}
	}

	public static void create(Object obj, Session session){
		// Begin session transaction
		session.beginTransaction();

		// Add object to the session
		session.save(obj);

		// Commit changes
		session.getTransaction().commit();
	}


	public static <T> T read(Class<T> c, long ID, Session session){
		// Begin session transaction
		session.beginTransaction();

		// Read object from session
		T toReturn = session.get(c, ID);

		// Commit changes
		session.getTransaction().commit();

		return toReturn;
	}

	public static void update(Object obj, Session session){
		// Begin session transaction
		session.beginTransaction();

		// Read object from session
		session.update(obj);

		// Commit changes
		session.getTransaction().commit();
	}

	public static void delete(Object obj, Session session){
		// Begin session transaction
		session.beginTransaction();

		// Read object from session
		session.delete(obj);

		// Commit changes
		session.getTransaction().commit();
	}


}
