package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.service.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RequestController {
    @Autowired
    RequestServiceImpl requestService;
}
