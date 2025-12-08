package br.com.supermarket.pooprj.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.ModelMap;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "user/home"; // nome do template sem extensão
    }
    

    @GetMapping("/access-denied")
    public String acessoNegado(ModelMap model, HttpServletResponse resp) {
		model.addAttribute("status", resp.getStatus());
		model.addAttribute("error", "Acesso Negado");
		model.addAttribute("message", "Você não tem permissão para acesso a esta área ou ação.");
		return "error";
	}	
}
