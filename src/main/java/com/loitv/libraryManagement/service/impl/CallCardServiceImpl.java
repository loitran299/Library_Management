package com.loitv.libraryManagement.service.impl;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.CallCardDetail;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.repository.CallCardDetailRepository;
import com.loitv.libraryManagement.repository.CallCardRepository;
import com.loitv.libraryManagement.repository.ReaderRepository;
import com.loitv.libraryManagement.service.CallCardDetailService;
import com.loitv.libraryManagement.service.CallCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CallCardServiceImpl implements CallCardService {

    @Autowired
    private CallCardRepository callCardRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private CallCardDetailRepository callCardDetailRepository;

    @Override
    public CallCard add(CallCard entity) {
        entity.setStatus("Chờ lấy");
        for (Book book : entity.getBooks()) {
            CallCardDetail detail = new CallCardDetail();
            detail.setCallCard(entity);
            detail.setBook(book);
            callCardDetailRepository.save(detail);
        }
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        entity.setBorrowedDate(sqlDate);
        return callCardRepository.save(entity);
    }

    @Override
    public long remove(Long id) {
        try {
            callCardRepository.deleteById(id);
        }catch (Exception e) {
            return 0;
        }
        return id;
    }

    @Override
    public CallCard update(CallCard entity) {
        callCardDetailRepository.deleteAllByCallCard_Id(entity.getId());
        for (Book book : entity.getBooks()) {
            CallCardDetail detail = new CallCardDetail();
            detail.setCallCard(entity);
            detail.setBook(book);
            callCardDetailRepository.save(detail);
        }
        return callCardRepository.save(entity);
    }

    @Override
    public boolean addBooks(long id, Set<Book> books) {
        CallCard callCard = callCardRepository.getById(id);
        Set<Book> oldBooks = callCard.getBooks();
        oldBooks.addAll(books);
        callCard.setBooks(oldBooks);
        try {
            callCardDetailRepository.deleteAllByCallCard_Id(callCard.getId());
            for (Book book : books) {
                CallCardDetail detail = new CallCardDetail();
                detail.setCallCard(callCard);
                detail.setBook(book);
                callCardDetailRepository.save(detail);
            }
            callCardRepository.save(callCard);

        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<CallCard> getByWaitingStatus(String information) {
        if(information.equals("")) return callCardRepository.findByStatus("Chờ lấy");
        List<Reader> readers = readerRepository.findAll();
        Reader reader = new Reader();
        information = information.toLowerCase(Locale.ROOT);
        for (Reader person : readers) {
            String match = person.getCode() + person.getFullName() + person.getUsername();
            match = match.toLowerCase(Locale.ROOT);
            if (match.contains(information)) {
                reader = person;
                break;
            }
        }
        List<CallCard> callCards = new ArrayList<CallCard>();
        if (reader.getId() != null) {
            callCards = callCardRepository.findByReaderAndStatus(reader, "Chờ lấy");
        }
        return callCards;
    }

    @Override
    public boolean confirmCallCard(long id) {
        boolean checked = false;
        try {
            CallCard callCard = callCardRepository.getById(id);
            callCard.setStatus("Đã lấy");
            callCardRepository.save(callCard);
            checked = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return checked;
    }

    @Override
    public List<CallCard> getByReaderId(long id) {
        return callCardRepository.findByReader_Id(id);
    }

    @Override
    public CallCard getById(Long id) {
        return callCardRepository.findById(id).get();
    }
}
