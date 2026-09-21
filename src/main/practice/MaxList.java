package practice;

import list.List;

/**
 * A MaxList is a List of integers that, in addition to every List operation,
 * can answer one more question: the cumulative maximum at a position — the
 * largest value among the elements from the start of the list up to and
 * including that position.
 *
 * <p>The element type is fixed to Integer.
 */
public interface MaxList extends List<Integer> {

  /**
   * Return the maximum value among the elements at positions 0 through index,
   * inclusive.
   *
   * @param index the position to compute the cumulative maximum up to.
   * @return the largest value in positions 0..index.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size().
   */
  int getMax(int index);
}
