package com.rmt_reborn.andersenlab.permisionkit.service;

import java.util.List;

public interface PermissionKitService {
    List<String> getCurrentUserAuthority();
    boolean hasPermission(String permission);

}
