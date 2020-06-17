package com.merve.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.merve.domain.Kullanici;
import com.merve.domain.Login;
import com.merve.service.KullaniciServisi;

@Controller
public class KullaniciController {
	@Autowired
	KullaniciServisi kullaniciServisi;

	public KullaniciServisi getKullaniciServisi() {
		return kullaniciServisi;
	}

	public void setKullaniciServisi(KullaniciServisi kullaniciServisi) {
		this.kullaniciServisi = kullaniciServisi;
	}

	@GetMapping("/")
	public String showLogin(Model model) {
		Login login = new Login();
		model.addAttribute("user-login", login);
		Kullanici user = new Kullanici();
		model.addAttribute("kullanici", user);
		return "index";
	}

	
	@GetMapping("/welcome")
	public String welcomePage(HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");
		if (oturumEmail == null) {
			return "redirect:/index";
		} else {
			return "secim";
		}
	}


	@PostMapping("/giris-yap")
	public String submitLogin(@ModelAttribute("kullanici") Kullanici user,
			 @ModelAttribute("user-login") @Valid Login login, BindingResult result, Model model, ModelMap modelmap, HttpSession oturum) {

	
		if (result.hasErrors()) {
			System.out.println("Hatalý kullanýcý adý veya sifre");
			return "index";
		}
		else {
			user=getKullaniciServisi().validateUserLogin(login.getEmail(),login.getPassword());
			if(user!=null) {
				oturum.setAttribute("oturumIsim", user.getUser_name());
				return "secim";
			}
			else {
				modelmap.put("error", "geçersiz hesap");
				return "index";
			}
			
		}

	}
}
