package com.example.ecommerceJwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {

    public static final String token_sign = "auntypolicebulalegifirbhipartyyhichalegi";

    public String createTokenFunction(Integer id){
        try{
            Algorithm algorithmObject = Algorithm.HMAC256(token_sign);
            String token = JWT.
                    create().
                    withClaim("userId", id.toString()).
                    withClaim("createdAt", new Date()).
                    sign(algorithmObject);

            return token;

        } catch (UnsupportedEncodingException | JWTCreationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserIdToken(String token){
        try{
            Algorithm algorithmObject = Algorithm.HMAC256(token_sign);
            JWTVerifier jwtVerifier = JWT.
                    require(algorithmObject).
                    build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            return decodedJWT.getClaim("userId").asString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isTokenValid(String token){
        String userId = this.getUserIdToken(token);
        return userId != null;
    }
}
