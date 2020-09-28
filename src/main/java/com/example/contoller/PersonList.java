package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class PersonList {

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET )
    public String index(Model model) {
        return "persons/personList";
    }

}
