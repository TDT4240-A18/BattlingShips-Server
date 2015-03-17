package no.ntnu.tdt4240.a18.battlingships.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/action")
@Controller
public class ActionController {
    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = {"", "index"})
    public String moveUp() {
        return "index";
    }
}
