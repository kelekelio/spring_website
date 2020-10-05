package com.example.contoller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class LoginRegister {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET )
    public String login(Model model) {

        return "loginPages/login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET )
    public String register(Model model) {

        return "loginPages/register";
    }



    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST )
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "/login";
    }

}
