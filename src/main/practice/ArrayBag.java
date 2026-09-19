package practice;

import java.util.Random;

/** A Bag with a seeded constructor, so a test can make its random draws repeatable. */
public class ArrayBag {

  private BallColor[] balls;
  private int size;
  private Random rng;

  public ArrayBag() {
    balls = new BallColor[10];
    size = 0;
    rng = new Random();
  }

  // Two bags built with the same seed draw the same sequence, given the same adds.
  public ArrayBag(long seed) {
    balls = new BallColor[10];
    size = 0;
    rng = new Random(seed);
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
