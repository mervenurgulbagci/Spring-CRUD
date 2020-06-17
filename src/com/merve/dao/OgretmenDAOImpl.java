package com.merve.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.merve.domain.Ogretmen;

//package scan esnasýnda ayaga kaldýr
@Repository
public class OgretmenDAOImpl implements OgretmenDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Ogretmen> getOgretmenler() {
		Session session = sessionFactory.getCurrentSession();
		// Ogretmen tabosundaki her seyi query edicez.Butun ogretmenleri getirmek icin
		Query<Ogretmen> query = session.createQuery("from Ogretmen", Ogretmen.class);
		//Listemizi doldurucaz.
		List<Ogretmen> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void saveOgretmen(Ogretmen ogrtmn) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ogrtmn);
	}

	@Override
	public Ogretmen getOgretmen(int ogrtmnId) {
		Session session = sessionFactory.getCurrentSession();

		Ogretmen ogrtmn = session.get(Ogretmen.class, ogrtmnId);
		return ogrtmn;
	}

	@Override
	public void deleteOgrtmn(int ogrtmnId) {
		Session session = sessionFactory.getCurrentSession();
		Ogretmen ogrtmn = session.get(Ogretmen.class, ogrtmnId);
		session.delete(ogrtmn);

	}

}
