package br.sc.senai.imob.config.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.sc.senai.imob.model.Users;


public class UserPrincipal {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private UserPrincipal(Users user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = user.getRoles().stream().map( role -> {
            return new SimpleGrantedAuthority("ROLE_".concat(role.getName()));
        }).collect(Collectors.toList());
    }

    public static UserPrincipal create(Users user){
        return new UserPrincipal(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
}