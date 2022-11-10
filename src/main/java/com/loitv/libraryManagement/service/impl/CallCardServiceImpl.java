package com.loitv.libraryManagement.service.impl;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.repository.CallCardRepository;
import com.loitv.libraryManagement.repository.ReaderRepository;
import com.loitv.libraryManagement.service.CallCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CallCardServiceImpl implements CallCardService {

    @Autowired
    private CallCardRepository callCardRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public CallCard add(CallCard entity) {
        entity.setStatus("Chờ lấy");
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
        return callCardRepository.save(entity);
    }

    @Override
    public boolean addBooks(long id, Set<Book> books) {
        CallCard callCard = callCardRepository.getById(id);
        Set<Book> oldBooks = callCard.getBooks();
        oldBooks.addAll(books);
        callCard.setBooks(oldBooks);
        try {
            callCardRepository.save(callCard);

        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<CallCard> getByWaitingStatus(String information) {
        List<Reader> readers = readerRepository.findAll();
        Reader reader = new Reader();
        for (Reader person : readers) {
            String match = person.getCode() + person.getFullName() + person.getUsername();
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
        return false;
    }

    @Override
    public List<CallCard> getByReaderId(long id) {
        return callCardRepository.findByReader_Id(id);
    }
}
