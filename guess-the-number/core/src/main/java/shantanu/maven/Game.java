package shantanu.maven;

public interface Game {

    int getNumber();

    int getGuess();

    int getGuessCount();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
