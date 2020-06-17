package com.merve.dao;

import java.util.List;
import com.merve.domain.Ogrenci;

public interface OgrenciDAO {
	public List<Ogrenci> getOgrenciler();

	public void saveOgrenci(Ogrenci ogr);

	public Ogrenci getOgrenci(int ogrId);

	public void deleteOgrenci(int ogrId);
}
