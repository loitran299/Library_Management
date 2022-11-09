package com.loitv.libraryManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Librarian extends Employee{
    private String code;

    @JsonIgnore
    @Transient
    @OneToMany(mappedBy = "librarian")
    private List<CallCard> callCards;
}
