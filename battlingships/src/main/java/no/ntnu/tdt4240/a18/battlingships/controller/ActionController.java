package no.ntnu.tdt4240.a18.battlingships.controller;


import no.ntnu.tdt4240.a18.battlingships.model.Game;
import no.ntnu.tdt4240.a18.battlingships.model.Result;
import no.ntnu.tdt4240.a18.battlingships.service.ActionService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * game actions
 */
@RequestMapping(value = "/action")
@Controller
public class ActionController {
    private ActionService actionService = new ActionService();

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "move", method = RequestMethod.GET)
    public String move(
            HttpServletRequest request, @RequestParam("username") String username, @RequestParam("x") int x,
            @RequestParam("y") int y) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        actionService.move(game, username, x, y);
        return new Result("move", "success", "game", game.toString()).toString();
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
