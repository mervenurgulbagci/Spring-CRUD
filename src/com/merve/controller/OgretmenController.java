package com.merve.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.merve.domain.Ogretmen;
import com.merve.service.OgretmenServisi;

@Controller
@RequestMapping("/ogretmen")
public class OgretmenController {
	// bu interfacei imp eden herhangi bean varsa onu bana gönder.component olarak
	// tanýmlanan ogrenciDAO mesela.
	@Autowired
	OgretmenServisi ogretmenServisi;
	

	@GetMapping("/list")
	public String listOgretmen(Model model) {
		List<Ogretmen> ogrtmnList = ogretmenServisi.getOgretmenler();
		model.addAttribute("ogretmenler", ogrtmnList);
		return "ogretmen-list";
	}

	@GetMapping("/ogretmen-ekle")
	public String ogrenciEkle(Model model) {
		Ogretmen ogrtmn = new Ogretmen();
		model.addAttribute("ogretmen", ogrtmn);
		return "ogretmen-form";
	}

	@PostMapping("/ogretmen-kaydet")
	public String ogrenciKaydet(@ModelAttribute("ogretmen") Ogretmen ogrtmn) {
		ogretmenServisi.saveOgretmen(ogrtmn);
		return "redirect:/ogretmen/list";
	}

	@GetMapping("/ogretmen-guncelle")
	public String ogretmenGuncelle(@RequestParam("ogretmenId") int ogrtmnId, Model model) {

		Ogretmen ogrtmn = ogretmenServisi.getOgretmen(ogrtmnId);
		model.addAttribute("ogretmen", ogrtmn);
		return "ogretmen-form";
	}
	
	@GetMapping("/ogretmen-sil")
	public String ogrenciSil(@RequestParam("ogretmenId") int ogrtmnId) {

		ogretmenServisi.deleteOgretmen(ogrtmnId);
		return "redirect:/ogretmen/list";
	}

}
