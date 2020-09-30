package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class Course {

    @RequestMapping(value = {"/Course"}, method = RequestMethod.GET )
    public String course(Model model) {
        return "course";
    }

}
