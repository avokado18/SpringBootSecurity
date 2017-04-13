package com.dsr.myProject.security;

import com.dsr.myProject.model.User;
import com.dsr.myProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userService.findByName(name);
        System.out.println(user.toString());
        if ((user != null) && (password.equals(user.getPassword()) && (checkIs18yearsOld(user.getBirthdate())))) {
            return new UsernamePasswordAuthenticationToken(
                    name, password, new ArrayList<GrantedAuthority>());
        } else {
            return null;
        }
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }

    private boolean checkIs18yearsOld(Date date){
        Date now = new Date();
        if (now.getYear() - date.getYear() < 18)
            return false;
        else
            if (now.getYear() - date.getYear() > 18)
                return true;
            else {
                if (now.getMonth() > date.getMonth())
                    return true;
                else
                    if (now.getMonth() < date.getMonth())
                        return false;
                    else {
                        if (now.getDate() >= date.getDate())
                            return true;
                        else
                            return false;
                    }
            }
    }
}
