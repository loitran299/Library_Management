package com.loitv.libraryManagement.service;

import com.loitv.libraryManagement.model.Librarian;
import com.loitv.libraryManagement.model.Reader;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReaderService extends BaseService<Reader> {
    Reader getByUsername(String username);
    Reader getById(Long id);
    List<Reader> getAll();
}
