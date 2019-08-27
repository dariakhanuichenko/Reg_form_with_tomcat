package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.dto.RequestInfoDto;

import java.util.List;

public interface RequestService {

    void save(String user,String username);
    List<RequestInfoDto>getRequestByUser(String creator);
    List<RequestInfoDto> getRequestByStatus(String status);
    List<String>findAllRequestTitle(String status);
}
