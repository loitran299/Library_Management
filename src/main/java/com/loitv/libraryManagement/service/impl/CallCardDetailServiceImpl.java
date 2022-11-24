package com.loitv.libraryManagement.service.impl;

import com.loitv.libraryManagement.model.CallCardDetail;
import com.loitv.libraryManagement.repository.CallCardDetailRepository;
import com.loitv.libraryManagement.repository.CallCardRepository;
import com.loitv.libraryManagement.service.CallCardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallCardDetailServiceImpl implements CallCardDetailService {

    @Autowired
    private CallCardDetailRepository callCardDetailRepository;

    @Override
    public CallCardDetail add(CallCardDetail entity) {
        return callCardDetailRepository.save(entity);
    }

    @Override
    public long remove(Long id) {
        try {
            callCardDetailRepository.deleteById(id);
        }catch (Exception e) {
            return 0;
        }
        return id;
    }

    @Override
    public CallCardDetail update(CallCardDetail entity) {
        return callCardDetailRepository.save(entity);
    }

    @Override
    public List<CallCardDetail> getByCallCardId(Long id) {
        return callCardDetailRepository.getByCallCardId(id);
    }

    @Override
    public CallCardDetail getById(Long id) {
        return callCardDetailRepository.getById(id);
    }
}
