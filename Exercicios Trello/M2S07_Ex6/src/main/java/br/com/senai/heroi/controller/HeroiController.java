package br.com.senai.heroi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<Heroi>> getHeroi() {
        List<Heroi> herois = service.find();
        return ResponseEntity.ok().body(herois);
    }

    @PostMapping
    public ResponseEntity<Heroi> saveHeroi(@RequestBody Heroi heroi) {
        service.save(heroi);

        return ResponseEntity.ok().body(heroi);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<List<Heroi>> getHeroi(@PathVariable String name) {
        List<Heroi> herois = service.find(name);
        return ResponseEntity.ok().body(herois);
    }
}