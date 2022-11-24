package com.loitv.libraryManagement.repository;

import com.loitv.libraryManagement.model.Book;
import com.loitv.libraryManagement.model.CallCard;
import com.loitv.libraryManagement.model.CallCardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CallCardDetailRepository extends JpaRepository<CallCardDetail, Long> {
    List<CallCardDetail> getByCallCardId(Long id);
    boolean existsByBookAndCallCard(Book book, CallCard callCard);
    @Transactional
    void deleteAllByCallCard_Id(Long id);
}