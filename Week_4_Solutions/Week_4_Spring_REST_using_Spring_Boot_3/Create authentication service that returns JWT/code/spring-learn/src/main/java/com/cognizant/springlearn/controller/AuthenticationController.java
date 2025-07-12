package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Authenticated User: {}", user);

        String token = generateJwt(user);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("START getUser()");
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        String username = decodedString.split(":", 2)[0];
        LOGGER.debug("END getUser()");
        return username;
    }

    private String generateJwt(String user) {
        LOGGER.debug("START generateJwt()");
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        String token = builder.compact();
        LOGGER.info("END generateJwt()");
        return token;
    }
}