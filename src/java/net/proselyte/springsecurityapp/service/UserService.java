package net.proselyte.springsecurityapp.service;


import net.proselyte.springsecurityapp.dto.UserDto;
import net.proselyte.springsecurityapp.model.User;

public interface UserService {
    void save(UserDto user);

    User findByUsername(String username);
}
