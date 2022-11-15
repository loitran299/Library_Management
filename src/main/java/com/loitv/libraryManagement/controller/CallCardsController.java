package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.Responses;
import com.loitv.libraryManagement.dto.BooksID;
import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.service.BookService;
import com.loitv.libraryManagement.service.CallCardService;
import com.loitv.libraryManagement.service.MySession;
import com.loitv.libraryManagement.service.ReaderService;
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

    @Autowired
    private ReaderService readerService;

    @GetMapping("/user")
    public List<CallCard> getByUser() {
        return callCardService.getByReaderId(MySession.getUserID());
    }

    @PostMapping
    public Responses addCallCard(@RequestBody BooksID ids){
        Responses response = new Responses();
        CallCard callCard = new CallCard();
        try {
            Reader reader = readerService.getById(MySession.getUserID());
            callCard.setReader(reader);
            Set<Book> set = new HashSet<>();
            for (Long id : ids.getIds()) {
                Book book = bookService.getById(id);
                set.add(book);
            }
            callCard.setReturnedDate(ids.getReturnedDate());
            callCard.setBooks(set);
            callCard = callCardService.add(callCard);
            response.setStatus(200);
            response.setMessage("Thêm phiếu mượn thành công");
        }catch (Exception e) {
            response.setStatus(400);
            response.setMessage("Thêm phiếu mượn thất bại");
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/{readerID}")
    public Responses addCallCardByLibrarian(@RequestBody BooksID ids, @PathVariable Long readerID){
        Responses response = new Responses();
        CallCard callCard = new CallCard();
        try {
            Reader reader = readerService.getById(readerID);
            callCard.setReader(reader);
            Set<Book> set = new HashSet<>();
            for (Long id : ids.getIds()) {
                Book book = bookService.getById(id);
                set.add(book);
            }
            callCard.setReturnedDate(ids.getReturnedDate());
            callCard.setBooks(set);
            callCard = callCardService.add(callCard);
            response.setStatus(200);
            response.setMessage("Thêm phiếu mượn thành công");
        }catch (Exception e) {
            response.setStatus(400);
            response.setMessage("Thêm phiếu mượn thất bại");
            e.printStackTrace();
        }
        return response;
    }

    @PutMapping("/{id}")
    public Responses save(@PathVariable Long id, @RequestBody BooksID booksID) {
        Responses response = new Responses();
        CallCard callCard = callCardService.getById(id);
        try {
            Set<Book> set = new HashSet<>();
            for (Long bookID : booksID.getIds()) {
                Book book = bookService.getById(bookID);
                set.add(book);
            }
            if (booksID.getReturnedDate() != null) {
                callCard.setReturnedDate(booksID.getReturnedDate());
            }
            callCard.setBooks(set);
            callCard = callCardService.update(callCard);
            response.setStatus(200);
            response.setMessage("Sửa phiếu mượn thành công");
        }catch (Exception e) {
            response.setStatus(400);
            response.setMessage("Sửa phiếu mượn thất bại");
            e.printStackTrace();
        }
        return response;
    }

    @PutMapping("/receive/{id}")
    public Responses changeStatus(@PathVariable Long id) {
        Responses response = new Responses();
        try {
            callCardService.confirmCallCard(id);
            response.setStatus(200);
            response.setMessage("Xác nhận thành công");
        }catch (Exception e) {
            response.setStatus(400);
            response.setMessage("Xác nhận không thành công");
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping("/find")
    public List<CallCard> findByReader(@RequestParam String information) {
        return callCardService.getByWaitingStatus(information);
    }
}
