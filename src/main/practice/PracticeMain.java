package practice;

/** A small demo of the Bag. The draw order changes from run to run. */
public class PracticeMain {

  public static void main(String[] args) {
    Bag bag = new Bag();
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLACK);
    bag.add(BallColor.BLUE);
    System.out.println("size before draws: " + bag.size());

    System.out.print("draws: ");
    while (bag.size() > 0) {
      System.out.print(bag.remove() + " ");
    }
    System.out.println();
    System.out.println("size after draining: " + bag.size());
  }
}
