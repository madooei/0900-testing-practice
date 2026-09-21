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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxIsMaximumOfPrefix() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxStaysWhenLaterElementsAreSmaller() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxWithDuplicateMaximum() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxUpdatesAfterSetToLargerValue() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxAfterLoweringOldMaximum() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxAfterRemovingOldMaximum() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxBelowRangeThrows() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxAboveRangeThrows() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Test
  public void getMaxOnEmptyListThrows() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
