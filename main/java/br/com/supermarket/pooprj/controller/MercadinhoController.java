package br.com.supermarket.pooprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MercadinhoController {

    @GetMapping("/mercadinho")
    public String home() {
        return "mercadinho"; // nome do template sem extensão
    }
}