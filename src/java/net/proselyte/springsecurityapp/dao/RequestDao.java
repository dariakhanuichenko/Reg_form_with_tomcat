package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface RequestDao extends JpaRepository<Request,Long> {

    List<Request> findByCreator(String creator);

    List<Request> findByStatus(String status);
    Map<Long,String> findIdAndRequestByStatus(String status);

    @Query(value="select request.request, request.creator as username, request.price " +
            "from request inner join users on request.master_id=users.id " +
            "where users.username=:username and request.status=:status",
            nativeQuery = true)
    List<RequestDto>findRequestCreatorPriceByMasterAndStatus(
            @Param("username")String master,
            @Param("status") String status);

}
