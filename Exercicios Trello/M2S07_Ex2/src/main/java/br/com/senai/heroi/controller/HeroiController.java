package br.com.senai.heroi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.heroi.model.Heroi;

@RestController
@RequestMapping("heroi")
public class HeroiController {

    @GetMapping
    public String getHeroi() {
        return "service.find()";
    }

    @PostMapping
    public String saveHeroi(@RequestBody Heroi heroi) {
        return "service.save(heroi)";
    }
}