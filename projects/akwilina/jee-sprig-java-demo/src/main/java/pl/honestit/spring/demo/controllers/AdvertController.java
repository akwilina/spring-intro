package pl.honestit.spring.demo.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.honestit.spring.demo.model.domain.Advert;
import pl.honestit.spring.demo.model.repositories.AdvertRepository;
import pl.honestit.spring.demo.model.repositories.UserRepository;

@Controller
@Slf4j @RequiredArgsConstructor
public class AdvertController {

	
	private final UserRepository userRepository;
	private final AdvertRepository advertRepository;
	
	
	@PostMapping("/add_advert")
	public String addAdvert(String title, String description, Principal principal) {
	    String username = principal.getName();
	        
	    Advert advert = new Advert();
	    advert.setUser(userRepository.findByUsername(username));
	    advert.setDescription(description);
	    advert.setTitle(title);
	    
	    log.info("Próba zapisu ogłoszenia: " + advert);
	    advert = advertRepository.save(advert);
	    log.info("Zapisano ogłoszenie: " + advert);

	    return "redirect:/";
	}
	
}
