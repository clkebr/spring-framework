package com.spring;

import com.spring.config.ProjectConfig;
import com.spring.model.Comment;
import com.spring.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Ecosystem");

        ApplicationContext context =new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService bean1 = context.getBean(CommentService.class);
        CommentService bean2 =context.getBean(CommentService.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        System.out.println(bean1==bean2);
    }
}
