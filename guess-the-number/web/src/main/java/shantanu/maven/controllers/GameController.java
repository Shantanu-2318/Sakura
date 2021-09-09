package shantanu.maven.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shantanu.maven.GameService;
import shantanu.maven.util.AttributeNames;
import shantanu.maven.util.GameMappings;
import shantanu.maven.util.ViewNames;

@Slf4j
@Controller
public class GameController {
    //== Constants ==
    private final GameService gameService;

    //== Constructor ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    //== Controllers ==
    @GetMapping(GameMappings.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("Model is = {}", model);
        if (gameService.isGameOver()){
            return ViewNames.GAME_OVER;
        }
        return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess){
        log.info("Guess is : {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String restart(){
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }
}
