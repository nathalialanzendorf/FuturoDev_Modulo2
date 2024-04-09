package br.com.senai.heroi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.heroi.model.Heroi;
import br.com.senai.heroi.service.HeroiServices;

@RestController
@RequestMapping("heroi")
public class HeroiController {

    private HeroiServices service;
    
    @Autowired
    public HeroiController(HeroiServices service) {
        this.service = service;
    }

    @GetMapping
    public List<Heroi> getHeroi() {
        return service.find();
    }

    @PostMapping
    public void saveHeroi(@RequestBody Heroi heroi) {
        service.save(heroi);
    }

    @GetMapping(value = "/{name}")
    public List<Heroi> getHeroi(@PathVariable String name) {
        return service.find(name);
    }
}