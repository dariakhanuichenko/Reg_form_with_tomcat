package net.proselyte.springsecurityapp.controller;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dto.CommentDto;
import net.proselyte.springsecurityapp.service.implementation.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Slf4j
@Controller
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @RequestMapping(value = { "/create_comment"}, method = RequestMethod.GET)
    public String create_request(Model model) {
        model.addAttribute("commentDto", new CommentDto());
        return "userCreateComment";
    }

    @RequestMapping(value = "/create_comment", method = RequestMethod.POST)
    public String create(Principal principal, @ModelAttribute("commentDto") CommentDto comment,
                         BindingResult bindingResult,
                         Model model) {
        if(bindingResult.hasErrors()){
            return "userCreateComment";
        }

        commentService.save(comment.getComment(),principal.getName());
        log.info("save comment(Controller)");
        log.info("comment:"+comment);

        return "userCreateComment";
    }
}
