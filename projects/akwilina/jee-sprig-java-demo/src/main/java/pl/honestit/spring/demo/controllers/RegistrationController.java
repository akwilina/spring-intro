package pl.honestit.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.honestit.spring.demo.model.domain.User;
import pl.honestit.spring.demo.model.repositories.UserRepository;

@Controller
@Slf4j @RequiredArgsConstructor //ta adnotacja uwzględnia all pola o typie final!!!! przy tworzeniu konstruktora
@RequestMapping("/register")
public class RegistrationController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
    @GetMapping
    public String prepareRegistrationPage() {
        return "/WEB-INF/views/registration-form.jsp";
    }

    @PostMapping
    public String processRegistrationPage(String username, String password, String firstName, String lastName) {
        
    	User user = new User();
    	user.setActive(true);
    	user.setUsername(username);
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	String encodedPassword = passwordEncoder.encode(password);
    	user.setPassword(encodedPassword);
    	
    	log.debug("Użytkownik do zapisania w bazie: {}", user);
    	userRepository.save(user);
    	log.debug("Użytkownik zapisany w bazie: {}", user);
    	
    	return "/WEB-INF/views/successful_registration.jsp";
    }
}
