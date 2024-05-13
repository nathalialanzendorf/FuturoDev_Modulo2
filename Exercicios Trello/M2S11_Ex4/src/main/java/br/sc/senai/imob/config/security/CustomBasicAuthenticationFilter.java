package br.sc.senai.imob.config.security;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.sc.senai.imob.model.Users;
import br.sc.senai.imob.service.UsersService;
import br.sc.senai.imob.utils.exceptions.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomBasicAuthenticationFilter extends OncePerRequestFilter{
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomBasicAuthenticationFilter.class);

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String JWT = "Bearer ";

    private String authorization;
    private String token;
    private String url;
    
    private UsersService userService;
    private JwtTokenService jwtTokenService;

    @Autowired
    public CustomBasicAuthenticationFilter(UsersService userService, JwtTokenService jwtTokenService){
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        LOGGER.info("Verifica tipo de autenticacao.");

        url = request.getRequestURI();
        
        if(isPrivateEndpoint()) {
            authorization = getAuthotization(request);

            if(isJWTAuthentication()){
                LOGGER.info("Token JWT.");

                token = getToken();

                LOGGER.info("Valida token JWT.");
                validateAuthentication();
            }else {
                throw new UnauthorizedException("Esperado token JWT valido");
            }
        }

        filterChain.doFilter(request, response);
    }
    
    private boolean isJWTAuthentication(){
        return authorization != null && authorization.startsWith(JWT);
    }

    public String getAuthotization(HttpServletRequest request){
        return request.getHeader(AUTHORIZATION_HEADER);
    }

    private String getToken() {
        LOGGER.info("Recupera token do header.");

        String jwt = authorization.replace(JWT, "");
        
        if(jwt == null){
            throw new UnauthorizedException("Token invalido");
        }

        return jwt;
    }

    private boolean isPrivateEndpoint(){
        LOGGER.info("Valida endpoint publico ou privado.");
        return !Arrays.asList(WebSecurityConfig.NO_AUTH).contains(url);
    }

    private void validateAuthentication(){
        LOGGER.info("Valida usuario.");

        String username = jwtTokenService.getUserByToken(token);

        Users user = userService.findByUsernameFetchRole(username);

        if(user == null || user.getUsername() == null || user.getPassword() == null){
            throw new UnauthorizedException("Usuario invalido");
        }

        boolean valid = userService.checkPassword(user.getPassword(), user.getPassword());            

        if(!valid){
            throw new UnauthorizedException("Senha invalida");
        }

        setAuthentication(user);
    }

    private void setAuthentication(Users user){
        Authentication authentication = createAuthenticationToken(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private Authentication createAuthenticationToken(Users user){
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
    }
}