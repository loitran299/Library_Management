package com.loitv.libraryManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CallCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date borrowedDate;

    private Date returnedDate;

    private String status;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PhieuMuon_Sach",
            joinColumns = @JoinColumn(name = "phieuMuon_id"),
            inverseJoinColumns = @JoinColumn(name = "sach_id"))
    private Set<Book> books;
}
