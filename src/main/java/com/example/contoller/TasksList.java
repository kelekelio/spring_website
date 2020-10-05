package com.example.contoller;



import com.example.model.Person;
import com.example.model.Tasks;
import com.example.repository.PersonRepository;
import com.example.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class TasksList {

    @Autowired
    TasksRepository tasksRepository;
    @Autowired
    PersonRepository personRepository;

    //all tasks
    @RequestMapping(value = {"/Tasks"}, method = RequestMethod.GET )
    public String viewTasks(Model model) {

        List<Tasks> list = tasksRepository.findAll();
        model.addAttribute("tasks", list);


        return "tasks/tasks";
    }

    //add task
    @RequestMapping(value = {"/addTask"}, method = RequestMethod.GET )
    public String viewAddNew(Model model) {

        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);

        return "tasks/addTask";
    }


    //add new task
    @RequestMapping(value = {"/addTask2"}, method = RequestMethod.POST )
    public RedirectView postNewTask(@ModelAttribute Tasks newTask) {
        tasksRepository.save(newTask);
        return new RedirectView("/Tasks");
    }


    //get edit task
    @RequestMapping(value = {"/editTask/{id}"}, method = RequestMethod.GET )
    public String viewEditTask(Model model, @PathVariable("id") Long id) {

        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);

        Tasks task = tasksRepository.findById(id);
        model.addAttribute("task", task);



        return "tasks/editTask";
    }


    //save edit task
    @RequestMapping(value = {"/editTaskSave/{id}"}, method = RequestMethod.POST )
    public RedirectView postEditedTask(@ModelAttribute Tasks newTask, @PathVariable("id") Long id) {

        tasksRepository.save(newTask);
        return new RedirectView("/Tasks");
    }


    @RequestMapping(value = {"/deleteTask/{id}"}, method = RequestMethod.POST)
    public RedirectView deleteTask(@ModelAttribute Tasks newTask, @PathVariable("id") Long id) {
        tasksRepository.delete(id);
        return new RedirectView("/Tasks");
    }


}
