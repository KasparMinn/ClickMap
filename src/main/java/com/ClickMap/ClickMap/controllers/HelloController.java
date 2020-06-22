package com.ClickMap.ClickMap.controllers;

import com.ClickMap.ClickMap.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloForm() { return "helloform"; }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String message(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");
        if (name == null) { name = " world!"; }

        model.addAttribute("message", HelloMessage.getMessage(name));
        return "index";

    }
}
