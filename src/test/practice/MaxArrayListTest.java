package practice;

/** Runs the List and getMax test suites against MaxArrayList. */
public class MaxArrayListTest extends MaxListTest {

  @Override
  protected MaxList createList() {
    return new MaxArrayList();
  }
}
