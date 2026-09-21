package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Implementation-specific tests for ArrayBag. They rely on its seeded constructor,
 * on remove using rng.nextInt(size), and on remove filling the gap with the last
 * ball.
 */
public class ArrayBagTest extends BagTest {

  private static final long SEED = 226;
  private static final int BALLS = 5;

  // drawnIndex[i] is the index that the i-th call to remove will draw
  private static int[] drawnIndex;

  @BeforeAll
  public static void computeDraws() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void seededRemoveFollowsTheKnownDraws() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
