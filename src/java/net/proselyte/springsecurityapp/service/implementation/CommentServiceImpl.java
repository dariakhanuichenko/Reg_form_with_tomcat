package net.proselyte.springsecurityapp.service.implementation;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dao.CommentDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Comment;
import net.proselyte.springsecurityapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    UserDao userDao;

    public void save(String comment,String username){
        commentDao.save(Comment.builder()
        .date( LocalDate.now())
        .comment(comment)
        .user(userDao.findByUsername(username))
        .build());

        log.info("{}", "Save comment(Service)");
    }
}
