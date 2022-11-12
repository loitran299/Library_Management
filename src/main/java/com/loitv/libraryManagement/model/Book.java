package com.loitv.libraryManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

    private Date dateAdded;

    private String status;

    private String notes;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private Set<CallCard> callCards;

    @ManyToOne
    @JoinColumn(name = "title_id")
    @JsonManagedReference
    private Title title;
}
