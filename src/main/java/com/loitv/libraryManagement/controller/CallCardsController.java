package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Member;
import com.loitv.libraryManagement.service.CallCardService;
import com.loitv.libraryManagement.service.CookieService;
import com.loitv.libraryManagement.service.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/api/call-card")
@SessionAttributes("user")
public class CallCardsController {
    @Autowired
    private CallCardService callCardService;



    @GetMapping("/user")
    public List<CallCard> getCallCardByUser(){
        return callCardService.getByReaderId(MySession.getUserID());
    }
}
