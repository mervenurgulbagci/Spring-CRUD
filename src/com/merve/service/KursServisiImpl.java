package com.merve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merve.dao.KursDAO;
import com.merve.domain.Kurs;
@Service
public class KursServisiImpl implements KursServisi {
	@Autowired
	private KursDAO kursDao;

	@Transactional
	@Override
	public List<Kurs> getKurslar() {
		return kursDao.getKurslar();
	}

	@Transactional
	@Override
	public void saveKurs(Kurs krs) {
		kursDao.getKurslar(krs);
		
	}

	@Transactional
	@Override
	public Kurs getKurslar(int kursId) {
		return kursDao.getKurslar(kursId);
	}

	@Transactional
	@Override
	public void deleteKurs(int kursId) {
		kursDao.deleteKurs(kursId);
		
	}

}
