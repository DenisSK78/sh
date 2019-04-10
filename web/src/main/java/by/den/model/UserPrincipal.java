package by.den.model;

import by.den.service.model.RoleDTO;
import by.den.service.model.UserSecurutyDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails{

    private UserSecurutyDTO userSecurutyDTO;
    private Collection<SimpleGrantedAuthority> grantedAuthorities;

    public UserPrincipal(UserSecurutyDTO userSecurutyDTO){
        this.userSecurutyDTO = userSecurutyDTO;
        grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(userSecurutyDTO.getRole()));
    }

    public RoleDTO getRole(){
        return RoleDTO.valueOf(userSecurutyDTO.getRole());
    }

    public Long getID() {
        return userSecurutyDTO.getId();}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userSecurutyDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userSecurutyDTO.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
