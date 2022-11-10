package com.loitv.libraryManagement.domain;

import com.loitv.libraryManagement.model.Member;
import com.loitv.libraryManagement.service.LibrarianService;
import com.loitv.libraryManagement.service.MySession;
import com.loitv.libraryManagement.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Login {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private LibrarianService librarianService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute Member member, Model model) { Member newMember = new Member();
        newMember = readerService.getByUsername(member.getUsername());
        if (newMember != null && newMember.getPassword().equals(member.getPassword())){
            model.addAttribute("user", newMember);
            MySession.setUserID(newMember.getId());
            return "readers/home";
        }
        newMember = librarianService.getByUsername(member.getUsername());
        if (newMember != null && newMember.getPassword().equals(member.getPassword())){
            model.addAttribute("user", newMember);
            MySession.setUserID(newMember.getId());
            return "librarian/home";
        }
        return "redirect:/login";
    }
}
