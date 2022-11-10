package com.loitv.libraryManagement.domain;

import com.loitv.libraryManagement.model.Reader;
import com.loitv.libraryManagement.service.CookieService;
import com.loitv.libraryManagement.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Register {
    @Autowired
    private CookieService cookieService;
    @Autowired
    private ReaderService readerService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute Reader reader, Model model, HttpSession session) throws Exception {
        Reader newReader = new Reader();
        newReader = readerService.add(reader);
        if(newReader.getId() != null) {
            model.addAttribute("user", newReader);
            session.setAttribute("user", newReader);
            return "redirect:/home-readers";
        }
        return "redirect:/register?status=false";
    }
}
