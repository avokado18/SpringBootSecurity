package com.dsr.myProject.security;

import java.util.Collection;
import java.util.List;

import com.dsr.myProject.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

public class CustomUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    private List<String> userRoles;

    public CustomUserDetails(User user, List<String> userRoles){
        super(user);
        this.userRoles=userRoles;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles=StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public String getUsername() {
        return super.getName();
    }
}