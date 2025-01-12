package prevInterviewQuestions;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomIntGenerator {
  private Random random;
  private Set<Integer> generatedNumbers;
  private int lowerBound;
  private int upperBound;

  public RandomIntGenerator(int lowerBound, int upperBound){
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.random = new Random();
    this.generatedNumbers = new HashSet<>();
  }

  public Integer generateUniqueRandom() {
    if (generatedNumbers.size() >= (upperBound - lowerBound)) {
      return null;
    }

    int randomNumber;
    do {
      randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
    } while (generatedNumbers.contains(randomNumber));

    generatedNumbers.add(randomNumber);
    return randomNumber;
  }
}
