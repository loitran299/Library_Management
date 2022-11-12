package com.loitv.libraryManagement.service.impl;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Title;
import com.loitv.libraryManagement.repository.BookRepository;
import com.loitv.libraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public long remove(Long id) {
        try {
            bookRepository.deleteById(id);
        }catch (Exception e) {
            return 0;
        }
        return id;
    }

    @Override
    public Book update(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public List<Book> getByCallCard(long callCardId) {
        return null;
    }

    @Override
    public List<Book> search(String information) {
        List<Book> result = new ArrayList<Book>();
        List<Book> books = bookRepository.findAll();
        information = information.toLowerCase(Locale.ROOT);
        for (Book book : books) {
            Title title = book.getTitle();
            String match = book.getCode() + book.getStatus() + book.getId() + title.getName() + title.getAuthor().getName() + title.getCategory().getName();
            match = match.toLowerCase(Locale.ROOT);
            if (match.contains(information)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }

}
