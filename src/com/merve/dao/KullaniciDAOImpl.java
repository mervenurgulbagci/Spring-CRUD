package com.merve.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.merve.domain.Kullanici;

@Repository
public class KullaniciDAOImpl implements KullaniciDAO {
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public List<Kullanici> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kullanici> query = session.createQuery("from Kullanici",Kullanici.class);
		List<Kullanici> resultList = query.getResultList();
		
		return resultList;
	}

	@Override
	public Kullanici validateUserLogin(String email, String password) {
		System.out.println("user  " + email + " " + password);
		Session session = sessionFactory.getCurrentSession();

		Query<Kullanici> query = session
				.createQuery("from Kullanici u where u.email= :email and u.password= :password", Kullanici.class)
				.setParameter("password", password).setParameter("email", email);
		List<Kullanici> resultList = query.getResultList();
		/*
		 * Query<User> us = session
		 * .createQuery("from User u where u.email= :email and u.password= :password",
		 * User.class) .setParameter("password", password).setParameter("email", email);
		 */
		System.out.println(resultList.toString());
		if (resultList != null && resultList.size() > 0)
			return resultList.get(0);
		else
			return null;

	}


}
