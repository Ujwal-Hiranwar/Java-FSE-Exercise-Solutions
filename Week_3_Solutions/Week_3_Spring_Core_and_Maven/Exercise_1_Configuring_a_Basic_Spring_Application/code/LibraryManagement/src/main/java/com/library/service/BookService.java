package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;


    public void printMessage() {
        System.out.println("BookService: initialized.");
    }
}
