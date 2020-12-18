package com.example.demo.Controller;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/hello")
public class HelloController {



    @RequestMapping("/showForm")
    public String getForm(){
        return "form";
    }

    // add data to model
    @RequestMapping("/form")
    public String getAnswer(HttpServletRequest request, Model model){
        String name = request.getParameter("StudentName");
        name = name.toUpperCase();
        String result = "MR " + name;

        model.addAttribute("message",result);
        return  "hello";
    }
    @RequestMapping("/formVersionThree")
    public String formVersionThree(@RequestParam("StudentName") String name, Model model){
        name = name.toUpperCase();
        String result = "MR " + name;

        model.addAttribute("message",result);
        return  "hello";
    }


    @RequestMapping("/processForm")
    public String getHello(){
        return "hello";
    }
}
