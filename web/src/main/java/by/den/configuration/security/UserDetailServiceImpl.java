package by.den.configuration.security;

import by.den.model.UserPrincipal;
import by.den.service.impl.UserServiceImpl;
import by.den.service.model.UserSecurutyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserSecurutyDTO userSecurutyDTO = userService.getFromSecurity(login);
        if (userSecurutyDTO == null) {
            throw new UsernameNotFoundException(login);
        }
        return new UserPrincipal(userSecurutyDTO);
    }
}
