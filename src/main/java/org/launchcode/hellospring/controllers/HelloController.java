package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // handle requests at path /hello
    @GetMapping
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // handle requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language, Model model){
        //String properGreeting = HelloController.createMessage(name, language);
        //return properGreeting;
        String properGreeting = HelloController.createMessage(name, language);
        model.addAttribute("greeting", properGreeting);
        return "hello";
    }

    // handle requests of the form hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String properGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", properGreeting);
        return "hello";
    }

    //exercises for ch 10
    public static String createMessage(String name, String language){
        if (language.equals("English")){
            return "Hello, " + name + "!";
        } else if (language.equals("French")){
            return "Bon Jour, " + name + "!";
        } else if (language.equals("Spanish")){
            return "Hola, " + name + "!";
        } else if (language.equals("German")){
            return "Hallo, " + name + "!";
        } else {
            return "Ello-hay, " + name + "!";
        }
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }//end helloForm

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> nameList = new ArrayList<>();
        nameList.add("Bre");
        nameList.add("Leo");
        nameList.add("Sasha");
        model.addAttribute("names", nameList);
        return "hello-list";
    }


}//end class
