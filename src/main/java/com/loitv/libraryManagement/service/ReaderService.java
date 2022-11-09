package com.loitv.libraryManagement.service;

import com.loitv.libraryManagement.model.Librarian;
import com.loitv.libraryManagement.model.Reader;
import org.springframework.stereotype.Service;


public interface ReaderService extends BaseService<Reader> {
    Reader getByUsername(String username);
}
