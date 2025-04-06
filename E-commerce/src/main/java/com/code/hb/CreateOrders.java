package com.code.hb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Product;
import com.code.entity.Users;




public class CreateOrders {
	private SessionFactory sessionFactory = null;
	public CreateOrders(SessionFactory sessionFactory)
	{
		//set the object
		this.sessionFactory = sessionFactory;
		//Session object using SessionFactory object
		Session session =  sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		
		// Fetch 3 products dynamically
		Query<Product> query = session.createQuery("FROM Product", Product.class);
				               query.setMaxResults(3);
		List<Product> products = query.getResultList();

		if (products.size() < 3) 
		{
				System.out.println("Sorry, not enough products found to create orders.");
				return;
		}

		Product p1 = products.get(0);
		Product p2 = products.get(1);
		Product p3 = products.get(2);
		
		//fetching users
		Query<Users> query1 = session.createQuery("FROM Users", Users.class);
        					   query1.setMaxResults(3);
        List<Users> user = query1.getResultList();

        if (user.size() < 2) 
        {
        	System.out.println("Sorry, not enough users found");
        	return;
        }

        Users u1 = user.get(0);
        Users u2 = user.get(1);
		
		//create order
		Orders o1 = new Orders(LocalDateTime.now(),new BigDecimal("5000.25"),u1);
		session.persist(o1);
		System.out.println("Order1 created for User1 with ID: " + o1.getId());
		
		//create order details
		OrderDetails od1 = new OrderDetails(2, 2000.0, o1,p1);
		OrderDetails od2 = new OrderDetails(1, 1000.25, o1,p2);
		session.persist(od1);
		session.persist(od2);
		System.out.println("OrderDetails for Order1 added.");
		
		//create order
		Orders o2 = new Orders(LocalDateTime.now(),new BigDecimal("5000.20"),u2);
		session.persist(o2);
		System.out.println("Order1 created for User2 with ID: " + o2.getId());
				
		//create order details
		OrderDetails ord = new OrderDetails(1, 5000.20, o2,p3);
		session.persist(ord);
		System.out.println("OrderDetails for Order2 added.");
		
		 //commit
		 session.getTransaction().commit();
		 //close the session object
		 session.close();
	}
}
