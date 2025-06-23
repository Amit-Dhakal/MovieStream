package com.live.jwtutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIdentityService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.live.Entity.User users = userRepo.findByUsernameOrEmail(username, username);
        //    List<GrantedAuthority> grantedAuthorityList=listUser.stream().map(new SimpleGrantedAuthority("role")).collect(Collectors.toList());
        List<GrantedAuthority> grantedAuthorityList = List.of(new SimpleGrantedAuthority(users.getRole()));
        return new User(users.getUsername(), users.getPassword(), grantedAuthorityList);
    }
}
