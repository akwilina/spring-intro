package pl.honestit.spring.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.honestit.spring.demo.model.domain.Advert;
import pl.honestit.spring.demo.model.repositories.AdvertRepository;

@Controller
@RequestMapping("/")
@Slf4j @RequiredArgsConstructor
public class HomePageController {

	private final AdvertRepository advertRepository;

	@GetMapping
	public String prepareHomePage (Model model) {
		List<Advert> listOfAllSortedAdverts = advertRepository.findAllByOrderByPostedDesc();
		
		model.addAttribute("adverts", listOfAllSortedAdverts );
		
		return "home_page";
	}
}