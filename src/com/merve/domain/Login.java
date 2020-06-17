package com.merve.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Login {
	@NotEmpty(message = "Email bo� b�rak�lamaz")
	@Email(message = "Email girmelisiniz")
	private String email;
	@NotEmpty(message = "�ifre bo� b�rak�lamaz")
	private String password;
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
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
	
	

}
