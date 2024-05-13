package br.sc.senai.imob.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.sc.senai.imob.config.security.JwtTokenService;
import br.sc.senai.imob.config.security.UserPrincipal;
import br.sc.senai.imob.dto.TokenV1Dto;
import br.sc.senai.imob.model.Users;

@Component
public class AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    private AuthenticationManager authenticationManager;
    private JwtTokenService jwtTokenService;
    private UsersService userService;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, UsersService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
    }

    public String authenticate(String username, String password){
        LOGGER.info("Autenticando o usuario: {}", username);
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(username, password);
        
        Authentication authentication = authenticationManager.authenticate(userAuth);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
         /*
         Users user = userService.findByUsernameFetchRole(username);
         UserPrincipal userPrincipal = new UserPrincipal(user);
          */

        String token = jwtTokenService.generateToken(userPrincipal);
        
        return token;
    }
}