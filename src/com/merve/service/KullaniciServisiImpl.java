package com.merve.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.merve.dao.KullaniciDAO;
import com.merve.domain.Kullanici;
@Service
public class KullaniciServisiImpl implements KullaniciServisi {
	@Autowired
	KullaniciDAO kullaniciDao;

	
	public KullaniciDAO getKullaniciDao() {
		return kullaniciDao;
	}

	public void setKullaniciDao(KullaniciDAO kullaniciDao) {
		this.kullaniciDao = kullaniciDao;
	}

	@Transactional
	@Override
	public List<Kullanici> getUsers() {
		return kullaniciDao.getUsers();
	}

	@Transactional
	@Override
	public Kullanici validateUserLogin(String email, String password) {
		Kullanici kullanici=getKullaniciDao().validateUserLogin(email,password);
				
		return kullanici;
	}

}
