package demo;

import practice.MaxArrayList;

/** A demo of MaxArrayList on the example list [5, 7, 3, 8] from the notes. */
public final class MaxArrayListDemo {

  private MaxArrayListDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    MaxArrayList list = new MaxArrayList();
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
