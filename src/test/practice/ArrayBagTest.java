package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Implementation-specific tests for ArrayBag. They rely on its seeded constructor,
 * on how it stores balls, and on remove using rng.nextInt(size). With seed 2, the
 * first nextInt(2) returns 1 and the next nextInt(1) returns 0.
 */
public class ArrayBagTest {

  @Test
  public void seededRemoveDrawsPredictableBall() {
    ArrayBag bag = new ArrayBag(2);
    bag.add(BallColor.BLACK);  // index 0
    bag.add(BallColor.BLUE);   // index 1

    assertEquals(BallColor.BLUE, bag.remove());
    assertEquals(1, bag.size());
  }

  @Test
  public void seededRemoveSequenceIsRepeatable() {
    ArrayBag bag = new ArrayBag(2);
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLUE);

    // First draw takes index 1 (BLUE) and fills the gap with the last ball,
    // leaving BLACK; the next draw must return BLACK.
    assertEquals(BallColor.BLUE, bag.remove());
    assertEquals(BallColor.BLACK, bag.remove());
    assertEquals(0, bag.size());
  }
}
