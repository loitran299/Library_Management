package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.Responses;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.repository.MemberRepository;
import com.loitv.libraryManagement.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReadersController {
    @Autowired
    private ReaderService readerService;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<Reader> getAll() {
        return readerService.getAll();
    }

    @PostMapping
    public Responses addReader(@RequestBody Reader reader) {
        Responses responses = new Responses();
        if(memberRepository.existsByUsername(reader.getUsername())){
            responses.setStatus(400);
            responses.setMessage("Tên đăng nhập đã tồn tại");
            return  responses;
        }
        if(memberRepository.existsByEmail(reader.getEmail())){
            responses.setStatus(400);
            responses.setMessage("Email đã tồn tại");
            return  responses;
        }
        if(memberRepository.existsByPhoneNumber(reader.getPhoneNumber())){
            responses.setStatus(400);
            responses.setMessage("Số điện thoại đã tồn tại");
            return  responses;
        }

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
