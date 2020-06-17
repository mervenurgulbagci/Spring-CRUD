package com.merve.service;

import java.util.List;
import com.merve.domain.Ogretmen;

public interface OgretmenServisi {
	public List<Ogretmen> getOgretmenler();

	public void saveOgretmen(Ogretmen ogrtmn);

	public Ogretmen getOgretmen(int ogrtmnId);

	public void deleteOgretmen(int ogrtmnId);
}
