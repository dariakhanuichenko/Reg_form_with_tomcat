package net.proselyte.springsecurityapp.controller;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.dto.UserDto;
import net.proselyte.springsecurityapp.service.implementation.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class RequestController {
    @Autowired
    RequestServiceImpl requestService;

//    @RequestMapping(value = "/new_request", method = RequestMethod.GET)
//    public String create(Model model) {
//        model.addAttribute("requestDto", new RequestDto());
//        return "userCreateRequest";
//    }

    @RequestMapping(value = "/create_request", method = RequestMethod.POST)
    public String create(@ModelAttribute("requestDto") RequestDto requestDto,
                               BindingResult bindingResult,
                               Model model) {
        log.info("request:"+requestDto.getRequest()+"; user: "+requestDto.getUsername());
        if(bindingResult.hasErrors()){
            return "userCreateRequest";
        }
        requestService.save(requestDto);
        log.info("save request(Controller)");
        log.info("request:"+requestDto.getRequest()+"; user: "+requestDto.getUsername());

        return "userCreateRequest";
    }


}
