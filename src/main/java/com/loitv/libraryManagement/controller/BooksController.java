package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        System.out.println(bookService.getAll());
        return bookService.getAll();
    }
}
