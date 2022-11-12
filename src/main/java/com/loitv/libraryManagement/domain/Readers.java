package com.loitv.libraryManagement.domain;

import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.service.MySession;
import com.loitv.libraryManagement.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Readers {
    @Autowired
    private ReaderService readerService;
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
    public String addBorrowBook(Model model) {
        Reader reader = readerService.getById(MySession.getUserID());
        model.addAttribute("user", reader);
        return "readers/addborrow";
    }
    @GetMapping("add-books")
    public String addBooks() {
        return "readers/addbooks";
    }

}
