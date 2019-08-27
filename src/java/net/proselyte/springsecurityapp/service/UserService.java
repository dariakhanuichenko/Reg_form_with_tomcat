package net.proselyte.springsecurityapp.service;


import net.proselyte.springsecurityapp.dto.UserDto;
import net.proselyte.springsecurityapp.model.User;

import java.util.List;

public interface UserService {
    void save(UserDto user);

    User findByUsername(String username);

    public List<String> getUsernamesByRole(String role);
}
