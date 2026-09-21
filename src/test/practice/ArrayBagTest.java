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
    Random reference = new Random(SEED);
    drawnIndex = new int[BALLS];
    for (int i = 0; i < BALLS; i++) {
      drawnIndex[i] = reference.nextInt(BALLS - i);  // the bag has one fewer ball each draw
    }
  }

  @Test
  public void seededRemoveFollowsTheKnownDraws() {
    ArrayBag bag = new ArrayBag(SEED);
    List<BallColor> expected = new ArrayList<>();
    BallColor[] balls = {
      BallColor.BLACK, BallColor.BLUE, BallColor.BLUE, BallColor.BLACK, BallColor.BLUE
    };
    for (BallColor ball : balls) {
      bag.add(ball);
      expected.add(ball);
    }

    for (int i = 0; i < BALLS; i++) {
      int index = drawnIndex[i];
      BallColor want = expected.get(index);
      expected.set(index, expected.get(expected.size() - 1));  // fill the gap with the last ball
      expected.remove(expected.size() - 1);

      assertEquals(want, bag.remove());
      assertEquals(BALLS - i - 1, bag.size());
    }
  }
}
