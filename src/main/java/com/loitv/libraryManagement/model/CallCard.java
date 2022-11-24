package com.loitv.libraryManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Nullable
    private Librarian librarian;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "callCard_Book",
            joinColumns = @JoinColumn(name = "callCard_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;

    @JsonIgnore
    @OneToMany(mappedBy = "callCard")
    private Set<CallCardDetail> callCardDetails;
}
