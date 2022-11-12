package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.Responses;
import com.loitv.libraryManagement.dto.BooksID;
import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.service.BookService;
import com.loitv.libraryManagement.service.CallCardService;
import com.loitv.libraryManagement.service.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/call-card")
public class CallCardsController {
    @Autowired
    private CallCardService callCardService;

    @Autowired
    private BookService bookService;

    @GetMapping("/user")
    public List<CallCard> getByUser() {
        return callCardService.getByReaderId(MySession.getUserID());
    }

    @PostMapping
    public Responses addCallCard(@RequestBody BooksID ids){
        Responses response = new Responses();
        CallCard callCard = new CallCard();
        try {
            Set<Book> set = new HashSet<>();
            for (Long id : ids.getIds()) {
                Book book = bookService.getById(id);
                set.add(book);
            }
            callCard.setBooks(set);
            callCard = callCardService.add(callCard);
            response.setData(callCard);
            response.setStatus(200);
            response.setMessage("Thêm phiếu mượn thành công");
        }catch (Exception e) {
            response.setStatus(400);
            response.setMessage("Thêm phiếu mượn thất bại");
            e.printStackTrace();
        }
        return response;
    }
}
