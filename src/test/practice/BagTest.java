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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void removeFromEmptyBagThrows() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void removeShrinksSizeByOne() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void removeReturnsABallThatWasAdded() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void drainingReturnsEveryBallAdded() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
