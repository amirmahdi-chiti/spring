package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
    @RequestMapping("/showForm")
    public String getForm(){
        return "form";
    }
}
