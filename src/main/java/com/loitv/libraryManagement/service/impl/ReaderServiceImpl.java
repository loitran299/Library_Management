package com.loitv.libraryManagement.service.impl;

import com.loitv.libraryManagement.model.Librarian;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.repository.ReaderRepository;
import com.loitv.libraryManagement.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService{
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public Reader add(Reader entity) {
        entity = readerRepository.save(entity);
        return entity;
    }

    @Override
    public long remove(Long id) {
        try {
            readerRepository.deleteById(id);
        }catch (Exception e) {
            return 0;
        }
        return id;
    }

    @Override
    public Reader update(Reader entity) {
        return readerRepository.save(entity);
    }

    @Override
    public Reader getByUsername(String username) {
        return readerRepository.getReaderByUsername(username);
    }
}
