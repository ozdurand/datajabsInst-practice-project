package com.datajabs.datajabsinstitute.controller;

import com.datajabs.datajabsinstitute.model.Person;
import com.datajabs.datajabsinstitute.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session){
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(null != person.getDataJabClass() && null != person.getDataJabClass().getName()){
            model.addAttribute("enrolledClass", person.getDataJabClass().getName());
        }

        session.setAttribute("loggedInPerson", person);

        return "dashboard.html";
    }
}
