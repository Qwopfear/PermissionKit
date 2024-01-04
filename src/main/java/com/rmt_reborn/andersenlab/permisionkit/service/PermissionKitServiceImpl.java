package com.rmt_reborn.andersenlab.permisionkit.service;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PermissionKitServiceImpl implements PermissionKitService {


    @Override
    public List<String> getCurrentUserAuthority() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .toList();

    }

    @Override
    public boolean hasPermission(String authorityName) {
        return getCurrentUserAuthority().stream().anyMatch(el -> el.equals(authorityName));
    }
}
