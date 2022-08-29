package com.spring;

import com.spring.model.Comment;
import com.spring.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		Comment comment = new Comment();
		comment.setAuthor("Johnson");
		comment.setText("Spring Ecosystem");

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CommentService commentService = context.getBean(CommentService.class);
		commentService.publishComment(comment);

	}

}
