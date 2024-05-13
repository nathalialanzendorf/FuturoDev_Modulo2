package br.sc.senai.imob.config.security;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.sc.senai.imob.model.Users;

public class UserPrincipal implements UserDetails {
    private static final String ROLE = "ROLE_";

    private Users user;

    @Autowired
    public UserPrincipal(Users user){
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles()
                .stream()
                .map(role -> {
                    return new SimpleGrantedAuthority(ROLE.concat(role.getName()));
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
         return user.getAccountDateExpire().isAfter(LocalDate.now());
     }

   @Override
   public boolean isAccountNonLocked() {
       return user.isLocked();
   }

   @Override
   public boolean isCredentialsNonExpired() {
       return user.getCredentialDateExpire().isAfter(LocalDate.now());
   }

   @Override
   public boolean isEnabled() {
       return user.isEnabled();
   }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}