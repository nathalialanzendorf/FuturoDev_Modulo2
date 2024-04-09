package br.com.senai.heroi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.senai.heroi.model.Heroi;

@Component
public class HeroiRepository {

    private List<Heroi> herois = new ArrayList<>();

    public List<Heroi> find() {
        return herois;
    }

    public void save(Heroi heroi) {
        herois.add(heroi);
    }

    public List<Heroi> find(String name) {
        return herois.stream().filter(heroi -> heroi.getNome().contains(name)).toList();
    }
}
