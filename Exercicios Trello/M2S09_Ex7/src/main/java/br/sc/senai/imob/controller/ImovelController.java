package br.sc.senai.imob.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senai.imob.dto.ImovelV1Dto;
import br.sc.senai.imob.model.Imovel;
import br.sc.senai.imob.service.ImovelService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/imovel")
public class ImovelController {

    private ImovelService service;
    private ModelMapper mapper;

    @Autowired
    public ImovelController(ImovelService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    
    @GetMapping
    public ResponseEntity<List<Imovel>> findAll() {
        List<Imovel> imoveis = service.findAll();
        return ResponseEntity.ok().body(imoveis);
    }
    
    @GetMapping("{codigo}")
    public ResponseEntity<Imovel> findByCodigo(@PathVariable Long codigo) {
        Imovel imovel = service.findById(codigo);
        return ResponseEntity.ok().body(imovel);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid ImovelV1Dto dto) {
        Imovel imovel = mapper.map(dto, Imovel.class);
        service.save(imovel);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Imovel> update(@PathVariable Long codigo, @RequestBody @Valid ImovelV1Dto dto) {
        Imovel imovel = service.findById(codigo);
        mapper.map(imovel, ImovelV1Dto.class);
        service.save(imovel);

        return ResponseEntity.ok().body(imovel);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<String> delete(@PathVariable Long codigo) {
        service.delete(codigo);
        
        return ResponseEntity.noContent().build();
    }
}
