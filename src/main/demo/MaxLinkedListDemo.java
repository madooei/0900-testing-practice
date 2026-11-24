package demo;

import practice.MaxLinkedList;

/** A demo of MaxLinkedList on the example list [5, 7, 3, 8] from the notes. */
public final class MaxLinkedListDemo {

  private MaxLinkedListDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    MaxLinkedList list = new MaxLinkedList();
    list.add(5);
    list.add(7);
    list.add(3);
    list.add(8);
    System.out.println("list: 5 7 3 8");

    // Expect the cumulative maxima 5, 7, 7, 8.
    for (int i = 0; i < list.size(); i++) {
      System.out.println("getMax(" + i + ") = " + list.getMax(i));
    }
  }
}
