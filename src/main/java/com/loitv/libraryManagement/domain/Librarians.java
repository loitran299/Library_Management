package com.loitv.libraryManagement.domain;

import com.loitv.libraryManagement.model.Librarian;
import com.loitv.libraryManagement.service.LibrarianService;
import com.loitv.libraryManagement.service.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Librarians {

    @Autowired
    private LibrarianService librarianService;

    @ModelAttribute("user")
    public Librarian getUser(HttpServletResponse response) throws IOException {
        if (MySession.getUserID() == null){
            response.sendRedirect("/login");
            return null;
        }
        return librarianService.getById(MySession.getUserID());
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
}
