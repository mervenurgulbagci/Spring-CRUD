package com.merve.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.merve.domain.Ogrenci;

//package scan esnas�nda ayaga kald�r
@Repository
public class OgrenciDaoImpl implements OgrenciDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Ogrenci> getOgrenciler() {
		Session session = sessionFactory.getCurrentSession();
		// Ogrenci tabosundaki her seyi query edicez.butun ogrencileri getirmek icin
		Query<Ogrenci> query = session.createQuery("from Ogrenci", Ogrenci.class);
		// listemizi doldurucaz
		List<Ogrenci> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void saveOgrenci(Ogrenci ogr) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ogr);
	}

	@Override
	public Ogrenci getOgrenci(int ogrId) {
		Session session = sessionFactory.getCurrentSession();

		Ogrenci ogr = session.get(Ogrenci.class, ogrId);
		return ogr;
	}

	@Override
	public void deleteOgrenci(int ogrId) {
		Session session = sessionFactory.getCurrentSession();
		Ogrenci ogr = session.get(Ogrenci.class, ogrId);
		session.delete(ogr);

	}

}
