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
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
    setMaxPointer(newNode);
    size++;
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
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node target = node(index);
    target.value = value;
    // The old value may have been a maximum, so every later prefix can change.
    repairMaxFrom(target);
  }

  @Override
  public int getMax(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return node(index).maxPointer.value;
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
    Node target = nodeOf(value);
    if (target == null) {
      return false;
    }
    Node afterRemoved = target.next;

    if (target.prev == null) {
      head = target.next;
    } else {
      target.prev.next = target.next;
    }

    if (target.next == null) {
      tail = target.prev;
    } else {
      target.next.prev = target.prev;
    }

    size--;
    // Later nodes may have pointed at the removed value.
    repairMaxFrom(afterRemoved);
    return true;
  }

  // Recompute maxPointer for start and every node after it. Does nothing when
  // start is null.
  private void repairMaxFrom(Node start) {
    Node current = start;
    while (current != null) {
      setMaxPointer(current);
      current = current.next;
    }
  }

  // Pre: node.prev, if it exists, already has a correct maxPointer.
  private void setMaxPointer(Node node) {
    if (node.prev == null || node.value >= node.prev.maxPointer.value) {
      node.maxPointer = node;
    } else {
      node.maxPointer = node.prev.maxPointer;
    }
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
