package shantanu.maven;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {
    //== Fields ==
    @Getter(AccessLevel.NONE)
    private Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    //== Constructor
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber,@MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //== Methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }
}
