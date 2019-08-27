package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestDao extends JpaRepository<Request,Long> {

    List<Request> findByCreator(String creator);

    List<Request> findByStatus(String status);
    List<String> findRequestByStatus(String status);
}
