package com.merve.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.merve.dao.OgretmenDAO;
import com.merve.domain.Ogretmen;
@Service
public class OgretmenServisiImpl implements OgretmenServisi {
	@Autowired
	private OgretmenDAO ogretmenDAO;

	@Transactional
	@Override
	public List<Ogretmen> getOgretmenler() {
		return ogretmenDAO.getOgretmenler();
	}

	@Transactional
	@Override
	public void saveOgretmen(Ogretmen ogrtmn) {
		ogretmenDAO.saveOgretmen(ogrtmn);
		
	}

	@Transactional
	@Override
	public Ogretmen getOgretmen(int ogrtmnId) {
		
		return ogretmenDAO.getOgretmen(ogrtmnId);
	}

	@Transactional
	@Override
	public void deleteOgretmen(int ogrtmnId) {
		ogretmenDAO.deleteOgrtmn(ogrtmnId);
		
	}
}
