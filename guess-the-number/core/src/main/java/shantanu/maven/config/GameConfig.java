package shantanu.maven.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import shantanu.maven.GuessCount;
import shantanu.maven.MaxNumber;
import shantanu.maven.MinNumber;

@Configuration
@ComponentScan(basePackages = "shantanu.maven")
@PropertySource(value = "config/game.properties")
public class GameConfig {

    //== Fields ==
    @Value("${maxNumber:100}")
    private int maxNumber;
    @Value("${guessCount:10}")
    private int guessCount;
    @Value("${minNumber:10}")
    private int minNumber;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
