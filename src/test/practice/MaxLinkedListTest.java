package practice;

/** Runs the List and getMax test suites against MaxLinkedList. */
public class MaxLinkedListTest extends MaxListTest {

  @Override
  protected MaxList createList() {
    return new MaxLinkedList();
  }
}
