package com.loitv.libraryManagement.service;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;

import java.util.List;
import java.util.Set;

public interface CallCardService extends BaseService<CallCard>{
    boolean addBooks(long id, Set<Book> books);
    List<CallCard> getByWaitingStatus(String information);
    boolean confirmCallCard(long id);
    List<CallCard> getByReaderId(long id);
}
