package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDao extends JpaRepository<Request,Long> {

}
