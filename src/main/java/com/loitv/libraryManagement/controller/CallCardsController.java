package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.Responses;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Member;
import com.loitv.libraryManagement.repository.CallCardRepository;
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
public class CallCardsController {
    @Autowired
    private CallCardService callCardService;


    @PostMapping
    public Responses addCallCard(@RequestBody CallCard callCard){
        Responses response = new Responses();
        try {
            response.setData(callCardService.add(callCard));
            response.setStatus(200);
            response.setMessage("Thêm phiếu mượn thành công");
        }catch (Exception e) {
            response.setStatus(400);
            response.setMessage("Thêm phiếu mượn thất bại");
        }
        return response;
    }
}
