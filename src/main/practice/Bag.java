package practice;

import java.util.Random;

/** An unordered bag of colored balls; remove draws one uniformly at random. */
public class Bag {

  private BallColor[] balls;
  private int size;
  private Random rng;

  public Bag() {
    balls = new BallColor[10];
    size = 0;
    rng = new Random();
  }

  public void add(BallColor ball) {
    if (size == balls.length) {
      grow();
    }
    balls[size] = ball;
    size++;
  }

  public BallColor remove() {
    if (size == 0) {
      throw new IllegalStateException("the bag is empty");
    }
    int i = rng.nextInt(size);
    BallColor drawn = balls[i];
    // The bag promises no order, so fill the gap with the last ball instead of
    // shifting.
    balls[i] = balls[size - 1];
    size--;
    balls[size] = null;
    return drawn;
  }

  public int size() {
    return size;
  }

  private void grow() {
    BallColor[] bigger = new BallColor[balls.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = balls[i];
    }
    balls = bigger;
  }
}
