package com.loitv.libraryManagement.domain;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.service.BookService;
import com.loitv.libraryManagement.service.CallCardService;
import com.loitv.libraryManagement.service.MySession;
import com.loitv.libraryManagement.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class Readers {
    @Autowired
    private ReaderService readerService;

    @Autowired
    private CallCardService callCardService;

    @Autowired
    private BookService bookService;

    @ModelAttribute("user")
    public Reader getUser(HttpServletResponse response) throws IOException {
        if (MySession.getUserID() == null){
            response.sendRedirect("/login");
            return null;
        }
        return readerService.getById(MySession.getUserID());
    }

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
        return "readers/addborrow";
    }
    @GetMapping("add-books")
    public String addBooks() {
        return "readers/addbooks";
    }

    @GetMapping("call-card-detail")
    public String callCardDetail(@RequestParam Long id, Model model){
        CallCard callCard = callCardService.getById(id);
        model.addAttribute("detail", callCard);
        return "readers/addborrow";
    }

    @GetMapping("book-detail")
    public String bookDetail(@RequestParam Long id,Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("bookDetail",book);
        return "common/bookdetail";
    }

}
