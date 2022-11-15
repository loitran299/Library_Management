package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.Responses;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReadersController {
    @Autowired
    private ReaderService readerService;

    @GetMapping
    public List<Reader> getAll() {
        return readerService.getAll();
    }

    @PostMapping
    public Responses addReader(@RequestBody Reader reader) {
        Responses responses = new Responses();
        try {
            responses.setData(readerService.add(reader));
            responses.setStatus(200);
            responses.setMessage("Tạo tài khoản thành công");
        }catch (Exception e) {
            responses.setStatus(400);
            responses.setMessage("Tạo tài khoản thất bại");
        }
        return  responses;
    }
}
