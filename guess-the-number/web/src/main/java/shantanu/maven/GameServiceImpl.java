package shantanu.maven;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    //== Constants ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    //== Constructor ==
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //== Life Cycle Callbacks ==
    @PostConstruct
    public void postConstruct(){
        log.info(messageGenerator.getMainMessage());
        log.info("The number is : {}", game.getNumber());
    }

    //== Public methods ==
    @Override
    public boolean isGameOver() {
        return (game.isGameLost() || game.isGameWon());
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
