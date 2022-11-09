package com.loitv.libraryManagement.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import java.sql.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Member{
    private String position;
    private Date joinedDate;
    private String department;
}
