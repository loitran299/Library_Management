package com.loitv.libraryManagement.service;

import com.loitv.libraryManagement.model.Librarian;

public interface LibrarianService extends BaseService<Librarian>{
    Librarian getByUsername(String username);
    Librarian getById(Long id);
}
