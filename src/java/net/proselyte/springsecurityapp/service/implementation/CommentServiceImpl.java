package net.proselyte.springsecurityapp.service.implementation;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dao.CommentDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Comment;
import net.proselyte.springsecurityapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    UserDao userDao;

    public void save(String comment, String username) {
        Comment commentItem = new Comment();
        commentItem.setDate(Calendar.getInstance());
        commentItem.setComment(comment);
        commentItem.setUser(userDao.findByUsername(username));
        log.info("{}", "id" + commentItem.getId());
        this.commentDao.save(commentItem);

        log.info("{}", "Save comment(Service)");
    }
}
