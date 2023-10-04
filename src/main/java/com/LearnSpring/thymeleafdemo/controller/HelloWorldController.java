package com.LearnSpring.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // create a controller method to show initial HTML form

    @RequestMapping("/showForm")
    public String showForm(){
        // src/main/resources/templates/helloworld-form.html
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    // create a controller method to process the HTML form
    public String processForm(){
        // src/main/resources/templates/helloworld-form.html
        return "helloworld";
    }

    // need a controller method to read form data and add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName"); //-> u argument dajem form field ime

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    //                                    ovdje sam odradio ono što je u 33. liniji koda
    public String processFormVersionThree(@RequestParam ("studentName") String theName, Model model){

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey My Friend From v3!  " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
