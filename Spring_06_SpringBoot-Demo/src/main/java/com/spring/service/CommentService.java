package com.spring.service;

import com.spring.model.Comment;
import com.spring.proxy.CommentNotificationProxy;
import com.spring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // default scope is singleton
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy //opposite of eager, if the scope is singleton this annotation avoid to create directly injection beans
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
    public  void  publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }
}
