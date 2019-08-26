package net.proselyte.springsecurityapp.service.implementation;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dao.RequestDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.model.Request;
import net.proselyte.springsecurityapp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestDao requestDao;

    @Autowired
    UserDao userDao;

    @Override
    public void save(RequestDto requestDto) {
        Request request = new Request();
//        request.builder()
//                .request(requestDto.getRequest())
//                .master(null)
//                .status("new")
//                .price(0L)
//                .creator(
//                        userDao.findByUsername(requestDto.getUsername()))
//                .build();
        request.setRequest(requestDto.getRequest());
        request.setStatus("new");
        request.setCreator(requestDto.getUsername());
        this.requestDao.save(request);
        log.info("Save request (Service)");
//        User user = new User();
//        user.setUsername(userDto.getUsername());
//        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        log.info("{}", roleDao.findByName(userDto.getRoles()));
//        roles.add(roleDao.findByName(userDto.getRoles()));
//
//        log.info("{}", roles.toString());
//        user.setRoles(roles);
//        this.userDao.save(user);

    }
}

