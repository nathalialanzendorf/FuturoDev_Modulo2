package br.sc.senai.imob.config.security;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.sc.senai.imob.utils.exceptions.UnauthorizedException;

@Component
public class JwtTokenService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenService.class);

    private static final String SECRET_KEY = "imobSecretKey";
    private static final String ISSUER = "imobApplication";
    
    public String generateToken(UserPrincipal user){
        LOGGER.info("Gerando token para o usuário: {}", user.getUsername());
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        return JWT.create()
            .withIssuer(ISSUER)
            .withIssuedAt(ZonedDateTime.now().toInstant())
            .withExpiresAt(ZonedDateTime.now().plusMinutes(5).toInstant())
            .withSubject(user.getUsername())
            .withClaim("ROLE", user.getAuthorities().stream().findFirst().get().getAuthority())
            .sign(algorithm);
    }

    public String getUserByToken(String token){
        LOGGER.info("Recupera usuario do token.");
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        try {
            return JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build()
                .verify(token)
                .getSubject();
                
        } catch (JWTVerificationException e) {
            throw new UnauthorizedException("Token invalido");
        }
    }
}