package com.loitv.libraryManagement.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Librarian extends Employee{
    private String code;
}
