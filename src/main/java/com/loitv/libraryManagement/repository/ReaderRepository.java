package com.loitv.libraryManagement.repository;

import com.loitv.libraryManagement.model.Librarian;
import com.loitv.libraryManagement.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    public Reader getReaderByUsername(String username);
}