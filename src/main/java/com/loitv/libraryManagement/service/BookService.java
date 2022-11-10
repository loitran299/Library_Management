package com.loitv.libraryManagement.service;

import com.loitv.libraryManagement.model.Book;

import java.util.List;

public interface BookService extends BaseService<Book>{
    List<Book> getByCallCard(long callCardId);
    List<Book> search(String information);
    List<Book> getAll();
}
