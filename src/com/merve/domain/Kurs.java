package com.merve.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="KURS")
public class Kurs {

	@Id
	@Column(name="ID")
	@SequenceGenerator(name="kurs_seq",sequenceName="KURS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="kurs_seq")
	private Integer id;
	
	@Column(name="KURS_ADI")
	private String kurs_adi;
	
	@Column(name="SAAT")
	private Integer saat;
	
	@ManyToOne
	@JoinColumn(name="OGRETMEN_ID")
	private Ogretmen ogretmen;
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKurs_adi() {
		return kurs_adi;
	}
	public void setKurs_adi(String kurs_adi) {
		this.kurs_adi = kurs_adi;
	}

	
	public Kurs( String kurs_adi, Integer saat, Ogretmen ogretmen) {
		super();
		this.kurs_adi = kurs_adi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}
	public Integer getSaat() {
		return saat;
	}
	public void setSaat(Integer saat) {
		this.saat = saat;
	}
	public Ogretmen getOgretmen() {
		return ogretmen;
	}
	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}
	public Kurs() {
		super();
	}
}
