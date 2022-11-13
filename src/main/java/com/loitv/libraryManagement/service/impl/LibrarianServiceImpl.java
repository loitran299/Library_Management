package com.loitv.libraryManagement.service.impl;

import com.loitv.libraryManagement.model.Librarian;
import com.loitv.libraryManagement.repository.LibrarianRepository;
import com.loitv.libraryManagement.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Autowired
    public LibrarianRepository librarianRepository;

    @Override
    public Librarian add(Librarian entity) {
        entity = librarianRepository.save(entity);
        return entity;
    }

    @Override
    public long remove(Long id) {
        try {
            librarianRepository.deleteById(id);
        }catch (Exception e) {
            return 0;
        }
        return id;
    }

    @Override
    public Librarian update(Librarian entity) {
        return librarianRepository.save(entity);
    }

    @Override
    public Librarian getByUsername(String username) {
        return librarianRepository.getLibrarianByUsername(username);
    }

    @Override
    public Librarian getById(Long id) {
        return librarianRepository.findById(id).get();
    }
}
