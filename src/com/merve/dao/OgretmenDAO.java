package com.merve.dao;

import java.util.List;

import com.merve.domain.Ogretmen;

public interface OgretmenDAO {

	public List<Ogretmen> getOgretmenler();

	public void saveOgretmen(Ogretmen ogrtmn);

	public Ogretmen getOgretmen(int ogrtmnId);

	public void deleteOgrtmn(int ogrtmnId);

}
