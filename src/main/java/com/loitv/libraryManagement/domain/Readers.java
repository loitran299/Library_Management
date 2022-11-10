package com.loitv.libraryManagement.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Readers {
    @GetMapping("home-readers")
    public String homeReaders() {
        return "readers/home";
    }
    @GetMapping("borrow-books")
    public String borrowBooks(HttpSession session) {
        System.out.println(session.getAttribute("user"));
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
