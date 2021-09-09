package shantanu.maven.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import shantanu.maven.Game;
import shantanu.maven.MessageGenerator;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    //== Constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //== Fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    //== Constructor ==
    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //== Event Listener ==
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent){
        log.info("start() --> Context Started");

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int number = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(number);
            game.check();

            if (game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Do you want to play again? y/n");

                String playAgain = scanner.nextLine().trim();

                if (playAgain.equalsIgnoreCase("n")){
                    break;
                }
                game.reset();
            }
        }
    }

}
