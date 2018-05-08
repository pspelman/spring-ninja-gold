package com.philspelman.springbootninjagold.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("Reached the ninja gold Index router");
        return "index";
    }
}
