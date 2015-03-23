package no.ntnu.tdt4240.a18.battlingships.controller;

import no.ntnu.tdt4240.a18.battlingships.model.Game;
import no.ntnu.tdt4240.a18.battlingships.model.Result;
import no.ntnu.tdt4240.a18.battlingships.service.GameService;
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
        Game game = gameService.create(username);
        application.setAttribute("game", game);
        return new Result("create", "success", "game", game.toString()).toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join(
            HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        game = this.gameService.join(game, username);
        if (game == null) {
            return new Result("join", "fail").toString();
        }
        return new Result("join", "success", "game", game.toString()).toString();
    }
}
