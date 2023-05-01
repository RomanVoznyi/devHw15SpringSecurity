package homework.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import  org.springframework.security.core.userdetails.User;

@Service
public class AuthService {

    private Authentication getAuth(){
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }

    public User getUser(){
        User user=(User) getAuth().getPrincipal();
        return user;
    }

    public Boolean hasAuthority(String name){
        return getUser().getAuthorities().stream().map(GrantedAuthority::getAuthority).anyMatch(it->it.equals(name));
    }

}
