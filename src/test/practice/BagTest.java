package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Contract tests for Bag. Since remove draws at random, they assert what holds on
 * every draw instead of which ball comes out.
 */
public class BagTest {

  private Bag bag;

  @BeforeEach
  public void setup() {
    bag = new Bag();
  }

  @Test
  public void newBagIsEmpty() {
    assertEquals(0, bag.size());
  }

  @Test
  public void addIncreasesSize() {
    bag.add(BallColor.BLACK);
    assertEquals(1, bag.size());
    bag.add(BallColor.BLUE);
    assertEquals(2, bag.size());
  }

  @Test
  public void removeFromEmptyBagThrows() {
    try {
      bag.remove();
      fail("expected IllegalStateException when removing from an empty bag");
    } catch (IllegalStateException e) {
      return;
    }
  }

  @Test
  public void removeShrinksSizeByOne() {
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLUE);
    bag.remove();
    assertEquals(1, bag.size());
  }

  @Test
  public void removeReturnsABallThatWasAdded() {
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLACK);
    assertEquals(BallColor.BLACK, bag.remove());
  }

  @Test
  public void drainingReturnsEveryBallAdded() {
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLUE);
    bag.add(BallColor.BLUE);
    int black = 0;
    int blue = 0;
    while (bag.size() > 0) {
      BallColor drawn = bag.remove();
      if (drawn == BallColor.BLACK) {
        black++;
      } else {
        blue++;
      }
    }
    assertEquals(3, black);
    assertEquals(2, blue);
    assertEquals(0, bag.size());
  }
}
