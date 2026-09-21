package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import list.ListTest;

/**
 * The contract test suite for MaxList: the inherited List tests plus the getMax
 * tests. It keeps its own maxList field because the List field in ListTest is
 * typed List and cannot call getMax.
 */
public abstract class MaxListTest extends ListTest {

  private MaxList maxList;

  @Override
  protected abstract MaxList createList();

  @BeforeEach
  public void setupMax() {
    maxList = createList();
  }

  @Test
  public void getMaxOfSingleElement() {
    maxList.add(5);
    assertEquals(5, maxList.getMax(0));
  }

  @Test
  public void getMaxIsMaximumOfPrefix() {
    maxList.add(5);
    maxList.add(7);
    maxList.add(3);
    maxList.add(8);
    assertEquals(5, maxList.getMax(0));
    assertEquals(7, maxList.getMax(1));
    assertEquals(7, maxList.getMax(2));
    assertEquals(8, maxList.getMax(3));
  }

  @Test
  public void getMaxStaysWhenLaterElementsAreSmaller() {
    maxList.add(8);
    maxList.add(5);
    maxList.add(3);
    assertEquals(8, maxList.getMax(2));
  }

  @Test
  public void getMaxWithDuplicateMaximum() {
    maxList.add(7);
    maxList.add(7);
    assertEquals(7, maxList.getMax(1));
  }

  @Test
  public void getMaxUpdatesAfterSetToLargerValue() {
    maxList.add(2);
    maxList.add(3);
    maxList.add(1);
    maxList.set(2, 5);
    assertEquals(5, maxList.getMax(2));
  }

  @Test
  public void getMaxAfterLoweringOldMaximum() {
    maxList.add(5);
    maxList.add(4);
    maxList.add(3);
    maxList.set(0, 1);
    assertEquals(1, maxList.getMax(0));
    assertEquals(4, maxList.getMax(1));
    assertEquals(4, maxList.getMax(2));
  }

  @Test
  public void getMaxAfterRemovingOldMaximum() {
    maxList.add(5);
    maxList.add(4);
    maxList.add(3);
    maxList.remove(5);
    assertEquals(4, maxList.getMax(0));
    assertEquals(4, maxList.getMax(1));
  }

  @Test
  public void getMaxBelowRangeThrows() {
    maxList.add(1);
    try {
      maxList.getMax(-1);
      fail("expected IndexOutOfBoundsException for index -1");
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }

  @Test
  public void getMaxAboveRangeThrows() {
    maxList.add(1);
    try {
      maxList.getMax(1);
      fail("expected IndexOutOfBoundsException for index == size()");
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }

  @Test
  public void getMaxOnEmptyListThrows() {
    try {
      maxList.getMax(0);
      fail("expected IndexOutOfBoundsException on an empty list");
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }
}
