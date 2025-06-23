package com.live.controller;

import com.live.Entity.User;
import com.live.jwtutils.JWTUtils;
import com.live.jwtutils.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/save-user")
    public ResponseEntity<User> saveUsers(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/fetch-users")
    public List<User> fetchAuthUsers() {
        return userRepo.findAll();
    }


//    @PostMapping("/accessToken")
//    public String getJWTToken(){
//        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//      UserDetails userDetails= (UserDetails) authentication.getPrincipal();
//      String accessToken=jwtUtils.generateJWTToken(userDetails);
//        return accessToken;
//    }

}
