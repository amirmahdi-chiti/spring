package com.example.demo.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.Security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    DOCTOR(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,DOCTOR_READ,DOCTOR_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ,DOCTOR_READ));

    private final Set<ApplicationUserPermission> Permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> applicationUserPermissions) {
        this.Permissions = applicationUserPermissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return Permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> grantedAuthorities = getPermissions().stream()
                .map(applicationUserPermission -> new SimpleGrantedAuthority(applicationUserPermission.getPermission()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" +this.name()));
        return grantedAuthorities;
    }
}
