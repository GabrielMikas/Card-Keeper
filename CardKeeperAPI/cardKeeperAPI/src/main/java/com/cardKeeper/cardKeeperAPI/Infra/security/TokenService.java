package com.cardKeeper.cardKeeperAPI.Infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.cardKeeper.cardKeeperAPI.Domain.users.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String tokenBuilder(User user){

        try{
            var algorithm = Algorithm.HMAC256("12345");
            return JWT.create().withIssuer("CardKeeper API")
                    .withSubject(user.getLogin())
                    .withExpiresAt(limitDate())
                    .sign(algorithm);

        } catch (JWTCreationException e){
            throw new RuntimeException("JWT creation error" + e);
        }

    }
    private Instant limitDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
