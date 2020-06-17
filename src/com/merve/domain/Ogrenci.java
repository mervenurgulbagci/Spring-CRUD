package com.merve.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="OGRENCI")
public class Ogrenci {

	@Id
	@Column(name="Id")
	@SequenceGenerator(name="ogrenci_seq",sequenceName="ogrenci_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ogrenci_seq")
	private Integer id;
	
//	@Pattern(regexp="[\\p{L}{3,}]", message="Ýsim sadece harflerden oluþabilir")
	@Column(name="ISIM")
	private String isim;
	
//	@Pattern(regexp="[\\p{L}{3,}]", message="Soyad sadece harflerden oluþabilir")
	@Column(name="SOYISIM")
	private String soyisim;
	
	@Column(name="OGRENCI_NO")
	private int ogrenciNo;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getSoyisim() {
		return soyisim;
	}
	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public int getOgrenciNo() {
		return ogrenciNo;
	}
	public void setOgrenciNo(int ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public Ogrenci(String isim, String soyisim, int ogrenciNo) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.ogrenciNo = ogrenciNo;
	}
	public Ogrenci() {
		super();
	}
}
