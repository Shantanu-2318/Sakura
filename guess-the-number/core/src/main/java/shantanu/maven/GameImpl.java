package shantanu.maven;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

//  == Fields ==
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;
    private final int guessCount;
    private int number;

    @Setter
    private int guess;

    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    //== Constructor ==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator,@GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    //== Lifecycle Callbacks ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is = {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("In GameImpl preDestroy()");
    }

    //  == Public Methods ==
    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange){
            if (guess > number){
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

//  == Private Methods ==
    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }

}
