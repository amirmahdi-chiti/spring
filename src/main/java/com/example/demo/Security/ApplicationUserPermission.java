package com.example.demo.Security;

public enum ApplicationUserPermission {
    DOCTOR_READ("doctor:read"),
    DOCTOR_WRITE("doctor:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
