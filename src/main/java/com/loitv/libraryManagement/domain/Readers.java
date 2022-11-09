package com.loitv.libraryManagement.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Readers {
    @GetMapping("home-readers")
    public String homeReaders() {
        return "readers/home";
    }
    @GetMapping("borrow-books")
    public String borrowBooks() {
        return "readers/borrowbooks";
    }

    @GetMapping("add-borrow")
    public String addBorrowBook() {
        return "readers/addborrow";
    }
    @GetMapping("add-books")
    public String addBooks() {
        return "readers/addbooks";
    }

}
