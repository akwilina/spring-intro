package pl.honestit.spring.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/login")
@Slf4j @RequiredArgsConstructor
public class LoginController {
	
	@GetMapping
	public String prepareLoginPage() {
		return "/WEB-INF/views/logging_page.jsp";
	}

}
