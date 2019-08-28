package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.dto.RequestInfoDto;
import net.proselyte.springsecurityapp.model.Request;

import java.util.List;
import java.util.Map;

public interface RequestService {

    void save(String user,String username);
    List<RequestInfoDto>getRequestByUser(String creator);
    List<RequestInfoDto> getRequestByStatus(String status);
    Map<Long,String> findAllRequestTitle(String status);

    List<Request> findShortInfoByMasterAndStatus(String master, String status);

    Integer updateStatus(String newStatus, String currentStatus, String nameMaster,Long Id);

}
