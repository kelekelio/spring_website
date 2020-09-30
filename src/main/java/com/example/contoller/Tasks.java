package com.example.contoller;

import com.example.model.Items;
import com.example.model.Person;
import com.example.repository.ItemsRepository;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class Tasks {

    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    PersonRepository personRepository;

    // display tasks
    @RequestMapping(value = {"/Tasks"}, method = RequestMethod.GET )
    public String tasks(Model model) {

        List<Items> list = itemsRepository.findAll();
        model.addAttribute("items", list);

        return "tasks";
    }

    // display addTask
    @RequestMapping(value = {"/addTask"}, method = RequestMethod.GET )
    public String viewAddTask(Model model) {

        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);


        return "addTask";
    }




    // add new task
    @RequestMapping(value = {"/addTask2"}, method = RequestMethod.POST )
    public RedirectView postTask(@ModelAttribute Items newTask) {



        Person person = personRepository.findById((long) newTask.getTestid());
        newTask.setPerson(person);

        itemsRepository.save(newTask);
        return new RedirectView("/Tasks");
    }

}
