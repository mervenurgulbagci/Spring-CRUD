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
import com.merve.domain.Kurs;
import com.merve.service.KullaniciServisi;
import com.merve.service.KursServisi;

@Controller
@RequestMapping("/kurs")
public class KursController {
	
	@Autowired
	KursServisi kursServisi;
	
	@Autowired
	KullaniciServisi kullaniciServisi;
	
	@GetMapping("/list")
	public String kursListele(Model model) {
		List<Kurs> kursList=kursServisi.getKurslar();
		model.addAttribute("kurslar", kursList);
		return "kurs-list";
	}
	
	@GetMapping("/kurs-ekle")
	public String kursEkle(Model model) {
		Kurs krs=new Kurs();
		model.addAttribute("kurslar", krs);
		return "kurs-form";
	}
	
	@PostMapping("/kurs-kaydet")
	public String kursKaydet(@ModelAttribute("kurslar") Kurs krs)
	{
		kursServisi.saveKurs(krs);
		return "redirect:/kurs/list";
		
	}
	
	@GetMapping("/kurs-guncelle")
	public String kursGuncelle(@RequestParam("kursID") int kursId, Model model) {
		Kurs krs= kursServisi.getKurslar(kursId);
		model.addAttribute("kurslar", krs);
		return "kurs-form";
	}
	
	@GetMapping("/kurs-sil")
	public String kursSil(@RequestParam("kursID") int kursId) {
		 kursServisi.deleteKurs(kursId);
		return "redirect:/kurs/list";
	}
	


}
