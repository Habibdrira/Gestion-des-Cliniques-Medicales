package com.clinique.gestion_clinique_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")

    public String index() {
        return "dashboard/index";
    }

}
