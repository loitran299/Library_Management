package com.loitv.libraryManagement.domain;

import com.loitv.libraryManagement.model.CallCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Readers {
    @GetMapping("home-readers")
    public String homeReaders() {
        return "readers/home";
    }
    @GetMapping("borrow-books")
    public String borrowBooks(Model model) {
        CallCard callCard = new CallCard();
        model.addAttribute("callCard", callCard);
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
