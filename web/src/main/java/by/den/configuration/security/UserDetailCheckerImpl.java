package by.den.configuration.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

public class UserDetailCheckerImpl implements UserDetailsChecker{
    @Override
    public void check(UserDetails userDetails) {
    }
}
