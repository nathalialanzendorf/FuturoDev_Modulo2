package br.sc.senai.imob.dto;

import java.util.List;
import java.util.UUID;

import br.sc.senai.imob.model.Roles;

import lombok.Data;

@Data
public class UsersV1Dto {
    
    private UUID id;
    private String username;
    private String password;
    private List<Roles> roles;
}