package com.ClickMap.ClickMap.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("ajax")
public class AjaxController {

    public int[] mapPoints = { 0, 0 };
    public boolean hasClicked;

    public String pointName[];
    public String pointDesc[];


    public String index() {

        return "ajax/index";

    }
}
