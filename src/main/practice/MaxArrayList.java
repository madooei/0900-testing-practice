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
    if (size == elements.length) {
      grow();
    }
    elements[size] = value;
    if (size == 0) {
      maxes[size] = value;
    } else {
      maxes[size] = Math.max(maxes[size - 1], value);
    }
    size++;
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
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    elements[index] = value;
    // The old value may have been a maximum, so every later prefix can change.
    recomputeMaxesFrom(index);
  }

  @Override
  public int getMax(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return maxes[index];
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
    int i = indexOf(value);
    if (i == -1) {
      return false;
    }
    for (int j = i; j < size - 1; j++) {
      elements[j] = elements[j + 1];
    }
    size--;
    elements[size] = null;
    recomputeMaxesFrom(i);
    return true;
  }

  // Recompute maxes[index..size-1] from the previous position's running maximum.
  private void recomputeMaxesFrom(int index) {
    for (int i = index; i < size; i++) {
      if (i == 0) {
        maxes[i] = elements[i];
      } else {
        maxes[i] = Math.max(maxes[i - 1], elements[i]);
      }
    }
  }

  private void grow() {
    Integer[] biggerElements = new Integer[elements.length * 2];
    int[] biggerMaxes = new int[maxes.length * 2];
    for (int i = 0; i < size; i++) {
      biggerElements[i] = elements[i];
      biggerMaxes[i] = maxes[i];
    }
    elements = biggerElements;
    maxes = biggerMaxes;
  }
}
