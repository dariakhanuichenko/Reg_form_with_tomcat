package net.proselyte.springsecurityapp.service.implementation;

import net.proselyte.springsecurityapp.dao.CommentDao;
import net.proselyte.springsecurityapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;
}
