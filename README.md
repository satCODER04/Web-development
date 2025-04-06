**Overview**

This project is a basic e-commerce backend system built using Java and Hibernate. It allows you to manage Categories, Products, Users, and Orders with multiple Order Details. The application performs database interactions using Hibernate ORM, and MySQL is used as the backend database.

**Entity details**

1. Category Entity: 
          ⟶ id (Primary Key, auto-generated) 
          ⟶ name (Unique, Not Null) 
          ⟶ description 
          Relationship: One-to-Many with Product 

2. Product Entity: 
           ⟶ id (Primary Key, auto-generated) 
           ⟶ name (Not Null) 
           ⟶ price (Decimal, Not Null) 
           ⟶ stockQuantity (Integer) 
           Relationship: Many-to-One with Category

3. Users Entity: 
            ⟶ id (Primary Key, auto-generated) 
            ⟶ username (Unique, Not Null) 
            ⟶ password (Hashed, Not Null) 
            ⟶ email (Unique, Not Null) 
            ⟶ role (ADMIN, CUSTOMER) 
            Relationship: One-to-Many with Orders 

4. Orders Entity: 
             ⟶ id (Primary Key, auto-generated) 
             ⟶ orderDate (Timestamp, Not Null) 
             ⟶ totalAmount (Decimal, Not Null) 
             Relationship: Many-to-One with Users, One-to-Many with OrderDetails 

5. OrderDetails Entity: 
              ⟶ id (Primary Key, auto-generated) 
              ⟶ quantity (Integer, Not Null) 
              ⟶ unitPrice (Decimal, Not Null) 
              Relationship: Many-to-One with Orders, Many-to-One with Product
   
**Technologies used**
Java
Hibernate
MySQL
Maven
IDE (Eclipse or IntelliJ IDEA)

**Project features**

Insert new Categories, Products, and Users
Create Orders with multiple OrderDetails
Fetch Orders along with associated Users and Products
Hibernate ORM used for mapping entities and performing DB operations

**Setup Instructions**

 Clone the Repository
        ⟶ https://github.com/satCODER04/Web-development.git

    2. Open in your IDE
        ⟶ Use Eclipse, IntelliJ IDEA, or any preferred Java IDE.

   3. Configure Database
        ⟶ Set up a local MySQL (or any chosen DB) database.
        ⟶ Create a schema (e.g., ecommerce_db).
        ⟶ Update your hibernate.cfg.xml with:
                ∘ Database URL
                ∘ Username
                ∘ Password

    4. Run the Application
        ⟶ Make sure `hibernate.cfg.xml` is properly configured and MySQL server is 
              running.
        ⟶ Run App.java to initiate the SessionFactory.
        ⟶ Run:
                ∘ new CreateCategory(sessionFactory);
                ∘ new CreateProduct(sessionFactory);
                ∘ new CreateUsers(sessionFactory);
                ∘ new CreateOrders(sessionFactory);
                ∘ new Fetch(sessionFactory);

      5. Verify Database
        ⟶ Check the inserted data via MySQL Workbench or any SQL client.
**Development Highlights**

Java classes are annotated with JPA annotations like @Entity, @Table, @GeneratedValue, @Id, @OneToMany, and @ManyToOne to map objects to database tables.
Relationships between entities (Users, Orders, Products) are handled using proper Hibernate mappings.
Passwords are securely hashed using BCrypt before saving to the database.

**Authors and Acknowledgment**

Project Title was created by **[Satakshi Poddar](https://github.com/satCODER04)**
