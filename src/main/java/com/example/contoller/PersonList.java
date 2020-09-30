package com.example.contoller;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class PersonList {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET )
    public String viewPersonList(Model model) {

        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);


        return "persons/personList";
    }

    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.GET )
    public String viewAddNew(Model model) {
        return "persons/addNewPerson";
    }

    @RequestMapping(value = {"/addNewPerson2"}, method = RequestMethod.POST )
    public RedirectView postPersonList(@ModelAttribute Person newPerson) {

        personRepository.save(newPerson);
        return new RedirectView("/personList");
    }

    @RequestMapping(value = {"/editPerson/{id}"}, method = RequestMethod.GET )
    public String editPerson(Model model, @PathVariable("id") Long id) {

        Person person = personRepository.findById(id);
        model.addAttribute("person", person);
        return "persons/editPerson";
    }


    @RequestMapping(value = {"/editPerson2/{id}"}, method = RequestMethod.POST )
    public RedirectView saveEditPerson(@ModelAttribute Person editPerson, @PathVariable("id") Long id) {

        personRepository.save(editPerson);

        return new RedirectView("/editPerson/{id}");
    }


    @RequestMapping(value = {"/editPerson3/{id}"}, method = RequestMethod.POST)
    public RedirectView deleteEditPerson(@ModelAttribute Person editPerson, @PathVariable("id") Long id) {

        personRepository.delete(id);

        return new RedirectView("/personList");
    }




}
