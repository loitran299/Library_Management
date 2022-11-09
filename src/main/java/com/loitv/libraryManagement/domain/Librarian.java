package com.loitv.libraryManagement.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Librarian {

    @GetMapping("home-librarian")
    public String homeLibrarian() {
        return "librarian/home";
    }
}
