package com.merve.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity 
@Table(name="OGRETMEN")
public class Ogretmen {
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="ogretmen_seq",sequenceName="OGRETMEN_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ogretmen_seq")
	private Integer id;
	
	@Pattern(regexp="[\\p{L}{3,}]", message="Ýsim sadece harflerden oluþabilir")
	@Column(name="FIRST_NAME")
	private String ogrtmn_adi;
	@Pattern(regexp="[\\p{L}{3,}]", message="Soyad sadece harflerden oluþabilir")
	@Column(name="LAST_NAME")
	private String ogrtmn_soyadi;
	
	@Column(name="EMAIL")
	private String email;

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOgrtmn_adi() {
		return ogrtmn_adi;
	}
	

	public void setOgrtmn_adi(String ogrtmn_adi) {
		this.ogrtmn_adi = ogrtmn_adi;
	}

	public String getOgrtmn_soyadi() {
		return ogrtmn_soyadi;
	}

	public void setOgrtmn_soyadi(String ogrtmn_soyadi) {
		this.ogrtmn_soyadi = ogrtmn_soyadi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Ogretmen() {
		super();
	}

	@Override
	public String toString() {
		return  ogrtmn_adi ;
	}

	

	public Ogretmen(String ogrtmn_adi, String ogrtmn_soyadi, String email) {
		super();
		this.ogrtmn_adi = ogrtmn_adi;
		this.ogrtmn_soyadi = ogrtmn_soyadi;
		this.email = email;
	
	}


	
	

}
