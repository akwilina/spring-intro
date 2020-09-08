package pl.honestit.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pl.honestit.spring.demo.model.domain.User;
import pl.honestit.spring.demo.model.repositories.UserRepository;

@Controller
@Slf4j
@RequestMapping("/register")
public class RegistrationController {

	private final UserRepository userRepository;
	
	@Autowired
	public RegistrationController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
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
    	user.setPassword(password);
    	
    	log.debug("Użytkownik do zapisania w bazie: {}", user);
    	userRepository.save(user);
    	log.debug("Użytkownik zapisany w bazie: {}", user);
    	
    	return "/WEB-INF/views/successful_registration.jsp";
    }
}
