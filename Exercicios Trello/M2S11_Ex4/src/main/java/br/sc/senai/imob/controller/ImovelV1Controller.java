package br.sc.senai.imob.controller;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class ImovelV1Controller {

    private ImovelService service;
    private ModelMapper mapper;

    @Autowired
    public ImovelV1Controller(ImovelService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') OR hasRole('IMOVEL_READER')")
    //@Operation(summary = "Start the initial data load of the company")
    public ResponseEntity<List<Imovel>> findAll() {
        List<Imovel> imoveis = service.findAll();
        return ResponseEntity.ok().body(imoveis);
    }
    
    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') OR hasRole('IMOVEL_READER')")
    public ResponseEntity<Imovel> findById(@PathVariable UUID id) {
        Imovel imovel = service.findById(id);
        return ResponseEntity.ok().body(imovel);
    }

    @PostMapping
   // @PreAuthorize("hasRole('ADMIN') OR hasRole('IMOVEL_READER')")
    public ResponseEntity<String> save(@RequestBody @Valid ImovelV1Dto dto) {
        Imovel imovel = mapper.map(dto, Imovel.class);
        service.save(imovel);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
  //  @PreAuthorize("hasRole('ADMIN') OR hasRole('IMOVEL_READER')")
    public ResponseEntity<Imovel> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid ImovelV1Dto dto) {
        Imovel imovel = service.findById(id);
        mapper.map(imovel, ImovelV1Dto.class);
        service.save(imovel);

        return ResponseEntity.ok().body(imovel);
    }

    @DeleteMapping("{id}")
   // @PreAuthorize("hasRole('ADMIN') OR hasRole('IMOVEL_READER')")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}