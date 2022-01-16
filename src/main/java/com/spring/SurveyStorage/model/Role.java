package com.spring.SurveyStorage.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(com.spring.SurveyStorage.model.Permission.DEVELOPERS_READ)),
    MANAGER(Set.of(com.spring.SurveyStorage.model.Permission.DEVELOPERS_READ,
            com.spring.SurveyStorage.model.Permission.DEVELOPERS_WRITE)),
    ADMIN(Set.of(com.spring.SurveyStorage.model.Permission.DEVELOPERS_READ,
            com.spring.SurveyStorage.model.Permission.DEVELOPERS_WRITE,
            com.spring.SurveyStorage.model.Permission.DEVELOPERS_ADMIN));

    private final Set<com.spring.SurveyStorage.model.Permission> permissions;

    Role(Set<com.spring.SurveyStorage.model.Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<com.spring.SurveyStorage.model.Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
