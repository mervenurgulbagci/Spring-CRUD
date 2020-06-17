package com.merve.dao;

import java.util.List;
import com.merve.domain.Kullanici;


public interface KullaniciDAO {

	List<Kullanici> getUsers();

	Kullanici validateUserLogin(String email, String password);
	

}
