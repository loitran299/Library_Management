package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.service.BookService;
import com.loitv.libraryManagement.service.CallCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CallCardService callCardService;

    @GetMapping
    public List<Book> getBooks() {
        System.out.println(bookService.getAll());
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Set<Book> getByCallCardId(@PathVariable Long id) {
        CallCard callCard = callCardService.getById(id);
        return callCard.getBooks();
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String information){
        return bookService.search(information);
    }
}
