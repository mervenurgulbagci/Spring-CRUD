package com.merve.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.merve.domain.Ogrenci;
import com.merve.service.OgrenciServisi;

@Controller
@RequestMapping("/ogrenci")
public class OgrenciController {
	// bu interfacei imp eden herhangi bean varsa onu bana gönder.component olarak
	// tanýmlanan ogrenciDAO mesela.
	@Autowired
	OgrenciServisi ogrenciServisi;

	@GetMapping("/list")
	public String listOgrenci(Model model,HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			return "redirect:/index";
		} else {
		List<Ogrenci> ogrList = ogrenciServisi.getOgrenciler();
		model.addAttribute("ogrenci", ogrList);
		return "ogrenci-list";}
	}

	@GetMapping("/ogrenci-ekle")
	public String ogrenciEkle(Model model,HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			return "redirect:/index";
		} else {
		Ogrenci ogr = new Ogrenci();
		model.addAttribute("ogrenci", ogr);
		return "ogrenci-form";}
	}

	@PostMapping("/ogrenci-kaydet")
	public String ogrenciKaydet(@ModelAttribute("ogrenci") Ogrenci ogr) {
		ogrenciServisi.saveOgrenci(ogr);
		return "redirect:/ogrenci/list";
	}

	@GetMapping("/ogrenci-guncelle")
	public String ogrenciGuncelle(@RequestParam("ogrenciId") int ogrId, Model model,HttpSession oturum) {

		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			return "redirect:/index";
		} else {
		Ogrenci ogr = ogrenciServisi.getOgrenci(ogrId);
		model.addAttribute("ogrenci", ogr);
		return "ogrenci-form";} 
	}
	
	@GetMapping("/ogrenci-sil")
	public String ogrenciSil(@RequestParam("ogrenciId") int ogrId) {

		ogrenciServisi.deleteOgrenci(ogrId);
		return "redirect:/ogrenci/list";
	}
	
	

}
