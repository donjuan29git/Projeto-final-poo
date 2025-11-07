package br.com.supermarket.pooprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String home() {
        return "login"; // nome do template sem extensão
    }

    @PostMapping("/loginautenticator")
    public String loginAuthenticator() {
        return "redirect:/";
    }
}

