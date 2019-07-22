package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Controller
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/show-user")
    public String showUser(Model model){
        model.addAttribute("users",userService.findAll());
        return "/list";
    }

    @GetMapping("/create-user")
    public String createUser(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("/create-user")
    public ModelAndView createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("/create");
            modelAndView.addObject("user",user);
            return modelAndView;
        }else {
            userService.save(user);
            ModelAndView modelAndView=new ModelAndView("/list");
            modelAndView.addObject("users",userService.findAll());
            //modelAndView.addObject("message","Them thanh cong");
            return modelAndView;
        }

    }
}
