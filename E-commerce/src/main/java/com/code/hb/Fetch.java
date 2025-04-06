package com.code.hb;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Users;
import com.code.entity.Product;

public class Fetch {
    private SessionFactory sessionFactory;

    public Fetch(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        // Fetch all OrderDetails
        List<OrderDetails> orderDetailsList = session.createQuery("from OrderDetails", OrderDetails.class).getResultList();

        for (int i = 0; i < orderDetailsList.size(); i++) {
            OrderDetails od = orderDetailsList.get(i);

            Orders order = od.getOrders();     // Get Order
            Users user = order.getUsers();      // Get User from Order
            Product product = od.getProduct(); // Get Product from OrderDetails

            System.out.println("Order ID: " + order.getId());
            System.out.println("User Name: " + user.getUsername());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Quantity: " + od.getQuantity());
            System.out.println("Unit Price: " + od.getUnitPrice());
            System.out.println("----------------------------------");
        }
        //commit and close
        session.getTransaction().commit();
        session.close();
    }
}
