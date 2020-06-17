package com.merve.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merve.domain.Kurs;

@Repository
public class KursDAOImpl implements KursDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Kurs> getKurslar() {
		Session session = sessionFactory.getCurrentSession();
		// Kurs tablosundaki tum alanlarý getirmek icin query yaptim
		Query<Kurs> query = session.createQuery("from Kurs", Kurs.class);
		// Liste doldu
		List<Kurs> resultList = query.getResultList();
		return resultList;

	}

	@Override
	public void getKurslar(Kurs krs) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(krs);
	}

	@Override
	public Kurs getKurslar(int kursId) {
		Session session = sessionFactory.getCurrentSession();

		Kurs krs = session.get(Kurs.class, kursId);
		return krs;
	}

	@Override
	public void deleteKurs(int kursId) {
		Session session = sessionFactory.getCurrentSession();
		Kurs krs = session.get(Kurs.class, kursId);
		session.delete(krs);
	}

}
