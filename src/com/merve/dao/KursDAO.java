package com.merve.dao;

import java.util.List;
import com.merve.domain.Kurs;


public interface KursDAO {
	public List<Kurs> getKurslar();

	public void getKurslar(Kurs krs);

	public Kurs getKurslar(int kursId);

	public void deleteKurs(int kursId);
	

}
