package practice;

import java.util.Objects;

/** An array-based implementation of the MaxList ADT. */
public class MaxArrayList implements MaxList {

  private Integer[] elements;
  private int[] maxes;   // maxes[i] = max of elements[0..i]
  private int size;

  public MaxArrayList() {
    elements = new Integer[10];
    maxes = new int[10];
    size = 0;
  }

  @Override
  public void add(Integer value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public Integer get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return elements[index];
  }

  @Override
  public void set(int index, Integer value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public int getMax(int index) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(Integer value) {
    return indexOf(value) != -1;
  }

  @Override
  public int indexOf(Integer value) {
    for (int i = 0; i < size; i++) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean remove(Integer value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Recompute maxes[index..size-1] from the previous position's running maximum.
  private void recomputeMaxesFrom(int index) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private void grow() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
