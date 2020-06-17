package com.merve.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merve.dao.OgrenciDAO;
import com.merve.domain.Ogrenci;
@Service
public class OgrenciServisiImpl implements OgrenciServisi {
	@Autowired
	private OgrenciDAO ogrenciDAO;

	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {
		return ogrenciDAO.getOgrenciler();
	}

	@Transactional
	@Override
	public void saveOgrenci(Ogrenci ogr) {
		ogrenciDAO.saveOgrenci(ogr);
	}

	@Transactional
	@Override
	public Ogrenci getOgrenci(int ogrId) {
		
		return ogrenciDAO.getOgrenci(ogrId);
	}

	@Transactional
	@Override
	public void deleteOgrenci(int ogrId) {
		ogrenciDAO.deleteOgrenci(ogrId);
	}
}
