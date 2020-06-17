package com.merve.service;

import java.util.List;

import com.merve.domain.Kurs;


public interface KursServisi {
	public List<Kurs> getKurslar();

	public void saveKurs(Kurs krs);

	public Kurs getKurslar(int kursId);

	public void deleteKurs(int kursId);

}
