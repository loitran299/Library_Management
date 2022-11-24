package com.loitv.libraryManagement.controller;

import com.loitv.libraryManagement.Responses;
import com.loitv.libraryManagement.model.CallCardDetail;
import com.loitv.libraryManagement.service.CallCardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/call-card-detail")
public class CallCardDetailController {
    @Autowired
    private CallCardDetailService callCardDetailService;

    @GetMapping
    private List<CallCardDetail> getByCallCard(@RequestParam Long callCardId) {
        return callCardDetailService.getByCallCardId(callCardId);
    }

    @PutMapping
    private Responses update(@RequestParam Long id, @RequestParam String notes) {
        Responses response = new Responses();
        CallCardDetail detail = callCardDetailService.getById(id);
        try {
            detail.setNotes(notes);
            callCardDetailService.update(detail);
            response.setStatus(200);
            response.setMessage("Đã thêm tình trạng sách");
        }catch (Exception e) {
            e.printStackTrace();
            response.setStatus(400);
            response.setMessage("Thêm không thành công");
        }
        return response;
    }
}
