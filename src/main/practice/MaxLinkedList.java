package practice;

import java.util.Objects;

/** A linked-list implementation of the MaxList ADT. */
public class MaxLinkedList implements MaxList {

  private Node head;
  private Node tail;
  private int size;

  public MaxLinkedList() {
    head = null;
    tail = null;
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
    return node(index).value;
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
    Node current = head;
    int index = 0;
    while (current != null) {
      if (Objects.equals(current.value, value)) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  @Override
  public boolean remove(Integer value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Recompute maxPointer for start and every node after it. Does nothing when
  // start is null.
  private void repairMaxFrom(Node start) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Pre: node.prev, if it exists, already has a correct maxPointer.
  private void setMaxPointer(Node node) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private Node nodeOf(Integer value) {
    Node current = head;
    while (current != null) {
      if (Objects.equals(current.value, value)) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  private Node node(int index) {
    if (index < size / 2) {
      Node current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      return current;
    } else {
      Node current = tail;
      for (int i = size - 1; i > index; i--) {
        current = current.prev;
      }
      return current;
    }
  }

  private static class Node {
    Integer value;
    Node next;
    Node prev;
    Node maxPointer;   // the node holding the max value in the prefix ending here

    Node(Integer value) {
      this.value = value;
    }
  }
}
