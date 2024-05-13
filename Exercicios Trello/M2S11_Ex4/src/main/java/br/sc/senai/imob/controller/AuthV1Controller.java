package br.sc.senai.imob.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senai.imob.dto.AuthV1Dto;
import br.sc.senai.imob.dto.TokenV1Dto;
import br.sc.senai.imob.service.AuthService;
import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import br.sc.senai.imob.dto.TokenV1Dto;


@RestController
@RequestMapping("/v1/auth")
public class AuthV1Controller {

    private AuthService service;
    private ModelMapper modelMapper;

    @Autowired
    public AuthV1Controller(AuthService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<TokenV1Dto> authenticate (@RequestBody @Valid AuthV1Dto authV1Dto) {
        String token = service.authenticate(authV1Dto.getUsername(), authV1Dto.getPassword());
        TokenV1Dto tokenDto = new TokenV1Dto(token);
        return ResponseEntity.ok(tokenDto);
    }
}