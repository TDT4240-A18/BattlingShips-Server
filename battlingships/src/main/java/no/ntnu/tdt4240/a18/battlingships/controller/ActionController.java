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
        application.setAttribute("game", game);
        return new Result("move", "success", "game", game.toString()).toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "shoot", method = RequestMethod.GET)
    public String shoot(
            HttpServletRequest request, @RequestParam("username") String username, @RequestParam("x") int x,
            @RequestParam("y") int y) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        String shootResult = actionService.shoot(game, username, x, y);
        application.setAttribute("game", game);
        return new Result("shoot", "success", "result", shootResult).toString();
    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "doNothing", method = RequestMethod.GET)
    public String doNothing(HttpServletRequest request, @RequestParam("username") String username) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        if (game != null) {
            if (game.isInGame(username)) {
                game = actionService.doNothing(game, username);
                application.setAttribute("game", game);
                return new Result("doNothing", "success", "game", game.toString()).toString();
            }

            return new Result("doNothing", "success", "game", "you are not in the game!").toString();
        }
        return new Result("doNothing", "success", "game", "no game created").toString();
    }


    //    @Scope("prototype")
    //    @ResponseBody
    //    @RequestMapping(value = "check", method = RequestMethod.GET)
    //    public String check(@RequestParam("username") String username) {
    //        return "check";
    //    }

    @Scope("prototype")
    @ResponseBody
    @RequestMapping(value = "infor", method = RequestMethod.GET)
    public String infor(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        Game game = (Game) application.getAttribute("game");
        if (game == null) {
            return new Result("infor", "no game created").toString();
        }
        if (game.getState() == 0) {
            return new Result("infor", "game created", "playerList", game.getPlayerlist().toString(), game.getState())
                    .toString();
        }
        //        if (game.getPlayerlist().size() == 1 && game.getState() != 0) {
        //            return new Result(
        //                    "infor", "game started", "board", game.printBoard(), game.getPlayerlist().get(0)
        // .toString(),
        //                    game.getState(), game.getPlayerlist().toString(), game.getPlayerlistInactive().toString())
        //                    .toString();
        //        }
        // last player on the list win the game
        if (game.getPlayerlist().size() <= 1 && game.getState() >= 1) {
            String winner = game.getPlayerlist().get(0).getUsername();
            game = null;
            application.setAttribute("game", game);
            return new Result("finish", winner + " Win The Game !").toString();
        }

        return new Result(
                "infor", "game started", "board", game.printBoard(), (game.getPlayerlist().get(
                game.getState() % (game.getPlayerlist().size())).getUsername()), game.getState(),
                game.getPlayerlist().toString(), game.getPlayerlistInactive().toString()).toString();
    }
}
