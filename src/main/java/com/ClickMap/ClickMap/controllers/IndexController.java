package com.ClickMap.ClickMap.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // By convention, this returns Index to Spring MVC.
    // This makes the MVC look for a Thymeleaf template called 'index'.
    // The .html - affix is implied.

    @RequestMapping("/")
    public String index() { return "index"; }

}
