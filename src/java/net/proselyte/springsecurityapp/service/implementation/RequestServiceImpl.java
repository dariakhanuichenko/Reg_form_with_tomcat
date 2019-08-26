package net.proselyte.springsecurityapp.service.implementation;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dao.RequestDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.dto.RequestInfoDto;
import net.proselyte.springsecurityapp.model.Request;
import net.proselyte.springsecurityapp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestDao requestDao;

    @Autowired
    UserDao userDao;

    @Override
    public void save(String requestDto,String username) {
        Request request = new Request();
        request.setRequest(requestDto);
        request.setStatus("new");
        request.setCreator(username);
        this.requestDao.save(request);
        log.info("Save request (Service)");
    }

    @Override
    public List<RequestInfoDto> getRequestByUser(String creator) {
        List<RequestInfoDto> requestList= new ArrayList<>();
         List<Request> list=requestDao.findByCreator(creator);
        for (Request r:list
             ) {
            requestList.add(
                        RequestInfoDto.builder()
                        .request(r.getRequest())
                        .status(r.getStatus())
                        .price(Optional.ofNullable(r.getPrice()).orElse(0L).longValue())
                        .build()
                );
        log.info("{}",requestList.get(requestList.size()-1).toString());}
         return requestList;
    }

}

