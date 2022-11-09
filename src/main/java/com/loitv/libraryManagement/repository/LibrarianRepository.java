package com.loitv.libraryManagement.repository;

import com.loitv.libraryManagement.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    public Librarian getLibrarianByUsername(String username);
}