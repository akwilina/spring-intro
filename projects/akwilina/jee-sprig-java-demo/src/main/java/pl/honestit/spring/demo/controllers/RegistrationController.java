package pl.honestit.spring.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String prepareRegistrationPage() {
        // TODO
        return "";
    }

    @PostMapping
    public String processRegistrationPage() {
        // TODO
        return "";
    }
}
