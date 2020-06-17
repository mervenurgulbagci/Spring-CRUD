package com.merve.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "USERSSS")
@Component
@SessionScope
public class Kullanici  {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="users_seq",sequenceName="USERS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
	private Integer id;

	@Column(name = "EMAIL")
	@Email
	@NotEmpty(message="Email bo� kalmas�n lutfen")
	private String email;

	@Column(name = "PASSWORD")
	@NotEmpty(message="�ifre alan� bo� b�rak�lamaz")
	private String password;
	
	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "USER_SURNAME")
	private String user_surname;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "GENDER")
	private String gender;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getUser_surname() {
		return user_surname;
	}



	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Kullanici() {
		super();
	}



	@Override
	public String toString() {
		return "Kullanici [email=" + email + ", password=" + password + "]";
	}


	
}