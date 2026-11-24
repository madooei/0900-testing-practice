package practice;

/**
 * A Bag is an unordered collection of colored balls. You add balls to it, and
 * you draw one out at random.
 */
public interface Bag {

  /**
   * Put a ball in this bag.
   *
   * @param ball the ball to add.
   */
  void add(BallColor ball);

  /**
   * Draw a ball chosen uniformly at random, take it out of this bag, and return
   * it.
   *
   * @return the ball that was drawn.
   * @throws IllegalStateException if this bag is empty.
   */
  BallColor remove();

  /**
   * Return the number of balls in this bag.
   *
   * @return the number of balls.
   */
  int size();
}
