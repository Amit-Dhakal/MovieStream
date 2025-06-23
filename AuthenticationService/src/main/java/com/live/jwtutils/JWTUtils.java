package com.live.jwtutils;

import com.live.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class JWTUtils {

    private String claims;
    @Autowired
    private UserRepo userRepo;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateJWTToken(UserDetails userDetails) {
        User users = userRepo.findByUsernameOrEmail(userDetails.getUsername(), userDetails.getUsername());
        Collection<SimpleGrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(users.getRole()));
        String jwtToken = Jwts.builder().setSubject(users.getUsername()).claim("roles", authorityList).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 86400)).signWith(key()).compact();
        return jwtToken;
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

}
