package com.code.entity;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
			//member variables
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="id")
			private int id;
			@Column(name="username",length=200,unique=true,nullable=false)
			private String username;
			@Column(name="password",length=60,nullable=false)
			private String password;
			@Column(name="email",length=30,nullable=false)
			private String email;
			@Enumerated(EnumType.STRING)
			@Column(name="role",nullable=false)
			private Role role;
			private String hashPassword(String plainTextPassword) {
			        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
			    }
			//non-parameterized constructor
			public Users()
			{
				this.id = 0;
				this.username = null;
				this.password = hashPassword("");
				this.email = null;
				this.role = Role.CUSTOMER;
			}
			//parameterized constructor
			public Users(String username, String password, String email, Role role) {
				super();
				this.username = username;
				this.password =  hashPassword(password);;
				this.email = email;
				this.role = role;
			}
			//getters and setters
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
		        this.password = hashPassword(password); // Hash before setting
		    }
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public Role getRole() {
				return role;
			}
			public void setRole(Role role) {
				this.role = role;
			}
			@Override
			public String toString() {
				return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
						+ ", role=" + role + "]";
			}
}