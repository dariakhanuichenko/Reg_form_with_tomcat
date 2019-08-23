package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;
}
