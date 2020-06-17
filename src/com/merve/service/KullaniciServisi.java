package com.merve.service;

import java.util.List;
import com.merve.domain.Kullanici;

public interface KullaniciServisi {

	List<Kullanici> getUsers();

	Kullanici validateUserLogin(String email, String password);
	
	 
}
