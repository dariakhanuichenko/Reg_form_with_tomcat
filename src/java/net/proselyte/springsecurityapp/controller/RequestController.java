package net.proselyte.springsecurityapp.controller;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.dto.RequestInfoDto;
import net.proselyte.springsecurityapp.model.Request;
import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.service.implementation.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class RequestController {
    @Autowired
    RequestServiceImpl requestService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/create_request"}, method = RequestMethod.GET)
    public String create_request(Model model) {
        model.addAttribute("requestDto", new RequestDto());

        return "userCreateRequest";
    }

    @RequestMapping(value = "/create_request", method = RequestMethod.POST)
    public String create(Principal principal, @ModelAttribute("requestDto") RequestDto requestDto,
                         BindingResult bindingResult,
                         Model model) {
//        log.info("request:"+requestDto.getRequest()+"; user: "+requestDto.getUsername());
        if (bindingResult.hasErrors()) {
            return "userCreateRequest";
        }
        requestService.save(requestDto.getRequest(), principal.getName());
        log.info("save request(Controller)");
        log.info("request:" + requestDto);

        return "userCreateRequest";
    }

    @RequestMapping(value = {"/checkAllRequests"}, method = RequestMethod.GET)

    public String checkRequestsManager(Model model) {

        //log.info(requestService.getRequestByUser("sasha123451").toString());
        model.addAttribute("requestTitle", requestService.findAllRequestTitle("new"));
        List<RequestInfoDto> requestInfoDto = new ArrayList<>();
        Map<Long, String> temp = requestService.findAllRequestTitle("new");
        //TODO: update request data
        model.addAttribute("masters", userService.getUsernamesByRole("ROLE_MASTER"));
        model.addAttribute("requests", new RequestInfoDto());
        return "managerAllRequests";
    }

    @RequestMapping(value = {"/checkAllRequests"}, method = RequestMethod.POST)
    public String checkRequestsManager(@ModelAttribute("requests") RequestInfoDto requestInfoDto, BindingResult bindingResult,
                                       Model model) {
        if (bindingResult.hasErrors()) {
            return "userCreateRequest";
        }
        return "managerAllRequests";
    }


    @RequestMapping(value = {"/getUserRequest"}, method = RequestMethod.GET)

    public String getRequestByUser(Principal principal, Model model) {

        //log.info(requestService.getRequestByUser("sasha123451").toString());
        model.addAttribute("requests", requestService.getRequestByUser(principal.getName()));
        return "userAllRequests";
    }

    @RequestMapping(value = {"/getUserRequest"}, method = RequestMethod.POST)
    public String getRequestByUser(Model model) {
        return "userAllRequests";
    }


    @RequestMapping(value = {"/getMasterCompleteRequest"}, method = RequestMethod.GET)
    public String getCompleteRequestByMaster(Principal principal, Model model) {

        log.info(requestService.findShortInfoByMasterAndStatus(principal.getName(), "completed").get(0).toString());
        model.addAttribute("requests", requestService.findShortInfoByMasterAndStatus(principal.getName(), "completed"));
        return "masterCompletedRequests";
    }

    @RequestMapping(value = {"/getMasterCompleteRequest"}, method = RequestMethod.POST)
    public String getCompleteRequestByMaster(Model model) {
        return "masterCompletedRequests";
    }

    @RequestMapping(value = {"/getMasterAcceptedRequest"}, method = RequestMethod.GET)
    public String getAcceptedRequestByMaster(Principal principal, Model model) {
        model.addAttribute("request", new Request());
        log.info(requestService.findShortInfoByMasterAndStatus(principal.getName(), "accepted").get(0).toString());
        model.addAttribute("requests", requestService.findShortInfoByMasterAndStatus(principal.getName(), "accepted"));
        return "masterAcceptedRequests";
    }

    @RequestMapping(value = {"/getMasterAcceptedRequest"}, method = RequestMethod.POST)
    public String getAcceptedRequestByMaster(Model model,
                                             @ModelAttribute("request") Request request, Principal principal,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userCreateRequest";
        }

        requestService.updateStatus("accepted", "in process", principal.getName(), request.getId());
        return "masterAcceptedRequests";
    }

    @ModelAttribute
    public void provideid(Model model) {
        model.addAttribute("id", new Long(1));
    }
}
