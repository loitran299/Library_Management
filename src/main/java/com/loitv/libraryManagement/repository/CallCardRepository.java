package com.loitv.libraryManagement.repository;

import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallCardRepository extends JpaRepository<CallCard, Long> {
    List<CallCard> findByReaderAndStatus(Reader reader,String status);
    List<CallCard> findByReader_Id(Long readerId);
    List<CallCard> findByStatus(String status);
}