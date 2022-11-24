package com.loitv.libraryManagement.service;

import com.loitv.libraryManagement.model.CallCardDetail;

import java.util.List;

public interface CallCardDetailService extends BaseService<CallCardDetail>{
    List<CallCardDetail> getByCallCardId(Long id);
    CallCardDetail getById(Long id);
}
