package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.service.implementation.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;
}
