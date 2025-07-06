package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);

        // Test the beans
        bookService.printMessage();
        bookRepository.printMessage();

        ((ClassPathXmlApplicationContext) context).close();
    }
}