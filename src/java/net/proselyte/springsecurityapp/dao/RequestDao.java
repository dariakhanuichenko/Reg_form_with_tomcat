package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface RequestDao extends JpaRepository<Request, Long> {

    List<Request> findByCreator(String creator);

    List<Request> findByStatus(String status);

    Map<Long, String> findIdAndRequestByStatus(String status);

    @Query(value = "select request.* " +
            "from request inner join users on request.master_id=users.id " +
            "where users.username=:username and request.status=:status",
            nativeQuery = true)
    List<Request> findAllByMasterAndStatus(
            @Param("username") String master,
            @Param("status") String status
    );

    @Modifying(clearAutomatically = true)
    @Query(value = "update Request r set r.status=?1 " +
            "where r.status=?2 and r.master.id=?3 and r.id=?4")
    int updateStatus(String newStatus,
                     String currentStatus,
                     Long masterId,
                     Long id);

}
