package no.ntnu.tdt4240.a18.battlingships.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * game actions
 */
@RequestMapping(value = "/action")
@Controller
public class ActionController {
    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "move", method = RequestMethod.GET)
    public String move(
            @RequestParam("username") String username, @RequestParam("x") int x, @RequestParam("y") int y) {
        return "move";
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "shoot", method = RequestMethod.GET)
    public String shoot(@RequestParam("username") String username, @RequestParam("x") int x, @RequestParam("y") int y) {
        return "shoot";
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "doNothing", method = RequestMethod.GET)
    public String doNothing(@RequestParam("username") String username) {
        return "do nothing";
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "check", method = RequestMethod.GET)
    public String check(@RequestParam("username") String username) {
        return "check";
    }
}
