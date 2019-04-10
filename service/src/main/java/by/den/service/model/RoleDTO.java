package by.den.service.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleDTO implements GrantedAuthority{
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_SADMIN("ROLE_SADMIN"),
    ROLE_USER("ROLE_USER");

    private String role;
//
//    public String getRole() {
//        return role;
//    }

    RoleDTO(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
