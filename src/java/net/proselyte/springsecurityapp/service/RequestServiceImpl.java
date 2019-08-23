package net.proselyte.springsecurityapp.service;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dao.RequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestDao requestDao;
}

