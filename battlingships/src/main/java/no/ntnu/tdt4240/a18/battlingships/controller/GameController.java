package no.ntnu.tdt4240.a18.battlingships.controller;

import no.ntnu.tdt4240.a18.battlingships.model.Game;
import no.ntnu.tdt4240.a18.battlingships.model.Result;
import no.ntnu.tdt4240.a18.battlingships.service.GameService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


/**
 * create or join a game
 * <p/>
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 17, 2015.
 */
@RequestMapping(value = "/game")
@Controller
public class GameController {
    private GameService gameService = new GameService();

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(
            HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        if (application.getAttribute("game") != null) {return new Result("create", "fail").toString();}
        Game game = gameService.create(username);
        application.setAttribute("game", game);
        return new Result("create", "success", "game", game.getPlayerlist().toString()).toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join(
            HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        if (game == null) {
            return new Result("join", "no game to join").toString();
        }
        if (game.getState() == 0) {
            game = this.gameService.join(game, username);
            application.setAttribute("game", game);
            return new Result("join", "success", "game", game.getPlayerlist().toString()).toString();
        }
        return new Result("join", "cant not join after game started!").toString();

    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "ready", method = RequestMethod.GET)
    public String ready(
            HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        game = this.gameService.ready(game, username);
        if (game == null) {
            return new Result("ready", "fail").toString();
        }
        application.setAttribute("game", game);
        return new Result("ready", "success", "game", game.printBoard()).toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "check", method = RequestMethod.GET)
    public String check(
            HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        if (application.getAttribute("game") == null) {
            return new Result("check", "no game created").toString();
        }

        Game game = (Game) application.getAttribute("game");
        String currentPlayerName = this.gameService.check(game, username);
        if (currentPlayerName == null) {
            return new Result("check", "have game").toString();
        }
        return new Result("check", "success", "currentPlayerName", currentPlayerName).toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "leave", method = RequestMethod.GET)
    public String leave(
            HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        if (game == null) {
            return new Result("leave", "fail").toString();
        }
        game = this.gameService.leave(game, username);
        application.setAttribute("game", game);
        return new Result("leave", "success", "game", game.printBoard()).toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "finish", method = RequestMethod.GET)
    public String finish(
            HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        Game game = null;
        application.setAttribute("game", game);
        return new Result("finish", "success").toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "observe", method = RequestMethod.GET)
    public ModelAndView observe(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return new ModelAndView("index");
    }


}