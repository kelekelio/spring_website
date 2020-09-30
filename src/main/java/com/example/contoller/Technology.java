package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class Technology {

    @RequestMapping(value = {"/Technology"}, method = RequestMethod.GET )
    public String technology(Model model) {
        return "technology";
    }

}
