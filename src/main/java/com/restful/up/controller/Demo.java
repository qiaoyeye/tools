package com.restful.up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Demo {


    @RequestMapping("/login")
    public String login (ModelMap map){
        map.addAttribute( "temp","gexinwei" );
        return "login";

    }
    @RequestMapping("/")
    public String init (){
        return "login";

    }

}
