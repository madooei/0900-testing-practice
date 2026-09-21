package list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The contract test suite for the List ADT, written against the List interface
 * alone. A concrete subclass supplies createList() to pick the implementation.
 */
public abstract class ListTest {

  private List<Integer> list;

  protected abstract List<Integer> createList();

  @BeforeEach
  public void setup() {
    list = createList();
  }

  @Test
  public void newListIsEmpty() {
    assertEquals(0, list.size());
  }

  @Test
  public void addThenGetReturnsElement() {
    list.add(42);
    assertEquals(1, list.size());
    assertEquals(42, list.get(0));
  }

  @Test
  public void elementsComeBackInOrder() {
    list.add(10);
    list.add(20);
    list.add(30);
    assertEquals(10, list.get(0));
    assertEquals(20, list.get(1));
    assertEquals(30, list.get(2));
  }

  @Test
  public void containsFindsAddedElement() {
    list.add(5);
    assertTrue(list.contains(5));
  }

  @Test
  public void containsFalseForMissingElement() {
    list.add(5);
    assertFalse(list.contains(6));
  }

  @Test
  public void indexOfReturnsFirstOccurrence() {
    list.add(7);
    list.add(7);
    assertEquals(0, list.indexOf(7));
  }

  @Test
  public void indexOfMissingElementIsMinusOne() {
    list.add(1);
    assertEquals(-1, list.indexOf(2));
  }

  @Test
  public void setReplacesElement() {
    list.add(1);
    list.add(2);
    list.set(1, 99);
    assertEquals(99, list.get(1));
    assertEquals(2, list.size());
  }

  @Test
  public void removeOnlyElementLeavesEmpty() {
    list.add(99);
    assertTrue(list.remove(99));
    assertEquals(0, list.size());
  }

  @Test
  public void removeFirstElementShiftsTheRest() {
    list.add(1);
    list.add(2);
    list.add(3);
    assertTrue(list.remove(1));
    assertEquals(2, list.get(0));
    assertEquals(3, list.get(1));
    assertEquals(2, list.size());
  }

  @Test
  public void removeMiddleElementClosesTheGap() {
    list.add(1);
    list.add(2);
    list.add(3);
    assertTrue(list.remove(2));
    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));
    assertEquals(2, list.size());
  }

  @Test
  public void removeLastElementShrinksSize() {
    list.add(1);
    list.add(2);
    assertTrue(list.remove(2));
    assertEquals(1, list.get(0));
    assertEquals(1, list.size());
  }

  @Test
  public void removeMissingElementReturnsFalse() {
    list.add(1);
    assertFalse(list.remove(2));
    assertEquals(1, list.size());
  }

  @Test
  public void getOnEmptyListThrows() {
    try {
      list.get(0);
      fail("expected IndexOutOfBoundsException on an empty list");
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }

  @Test
  public void getBelowRangeThrows() {
    try {
      list.get(-1);
      fail("expected IndexOutOfBoundsException for index -1");
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }

  @Test
  public void getAboveRangeThrows() {
    list.add(1);
    try {
      list.get(1);   // size is 1, so index 1 is one past the last valid index
      fail("expected IndexOutOfBoundsException for index == size()");
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }

  @Test
  public void setOutOfRangeThrows() {
    try {
      list.set(0, 5);   // empty list: index 0 is out of range
      fail("expected IndexOutOfBoundsException when setting on an empty list");
    } catch (IndexOutOfBoundsException e) {
      return;
    }
  }
}
