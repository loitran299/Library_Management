package com.loitv.libraryManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Reader extends Member{
    private String code;

    @JsonIgnore
    @Transient
    @OneToMany(mappedBy = "reader")
    private List<CallCard> callCards;
}
