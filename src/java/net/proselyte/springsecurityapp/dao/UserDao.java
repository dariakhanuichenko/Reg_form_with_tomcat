package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.dto.UserInfoDto;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);

    @Query(value= "select  users.username from users " +
            "right join user_roles on user_roles.user_id=users.id " +
            "right join roles on user_roles.role_id=roles.id " +
            "where roles.name=:role", nativeQuery = true)
    List<String>findUserByRole(@Param("role") String role);

    Long findIdByUsername(String Username);


}
