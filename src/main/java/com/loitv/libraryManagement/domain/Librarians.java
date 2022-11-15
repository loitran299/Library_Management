package com.loitv.libraryManagement.domain;

import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Librarian;
import com.loitv.libraryManagement.service.CallCardService;
import com.loitv.libraryManagement.service.LibrarianService;
import com.loitv.libraryManagement.service.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Librarians {

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private CallCardService callCardService;

    @ModelAttribute("user")
    public Librarian getUser(HttpServletResponse response) throws IOException {
        if (MySession.getUserID() == null){
            response.sendRedirect("/login");
            return null;
        }
        return librarianService.getById(MySession.getUserID());
    }

    @GetMapping("borrow-detail")
    public String borrowdetail(@RequestParam Long id, Model model) {
        CallCard callCard = callCardService.getById(id);
        model.addAttribute("detail", callCard);
        return "librarian/borrowdetail";
    }

    @GetMapping("home-librarian")
    public String homeLibrarian() {
        return "librarian/home";
    }

    @GetMapping("book-management")
    public String booManagement() {
        return "librarian/bookmanagement";
    }

    @GetMapping("receive-book")
    public String receiveBook() {
        return "librarian/receivebook";
    }

    @GetMapping("borrow-book")
    public String borrowBooks() {
        return "librarian/addborrow";
    }


    @GetMapping("change-books")
    public String addBooks(@RequestParam Long callCardId, Model model) {
        model.addAttribute("callCardID",callCardId);
        return "librarian/addbooks";
    }
}
