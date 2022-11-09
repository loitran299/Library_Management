package com.loitv.libraryManagement.service;

import com.loitv.libraryManagement.model.Reader;
import org.springframework.stereotype.Service;


public interface BaseService<T> {
    T add(T entity);
    long remove(Long id);
    T update(T entity);
}
