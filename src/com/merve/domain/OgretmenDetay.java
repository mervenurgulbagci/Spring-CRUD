package com.merve.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OGRETMEN_DETAY")
public class OgretmenDetay {
	@Column(name="ID")
	@Id
	@SequenceGenerator(name="ogretmen_detay_seq",sequenceName="ogretmen_detay_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ogretmen_detay_seq")
	private Integer id;
	
	@Column(name="WEBSITE")
	private String website;
	
	@Column(name="HOBBY")
	private String hobby;
	
	@Column(name="EXPERTISE")
	private String expertise;
	
	@Column(name="FB_PAGE")
	private String fb_page;
	


	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getFb_page() {
		return fb_page;
	}

	public void setFb_page(String fb_page) {
		this.fb_page = fb_page;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OgretmenDetay() {
		super();
	}

	public OgretmenDetay(String website, String hobby, String expertise, String fb_page) {
		super();
		this.website = website;
		this.hobby = hobby;
		this.expertise = expertise;
		this.fb_page = fb_page;
	}
	

}
