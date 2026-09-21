# Testing — Practice: The Bag and MaxList

Two practice problems. A `Bag` of colored balls whose `remove` draws a ball at random, so its tests check invariants instead of exact outputs. And `MaxList`, a `List<Integer>` with a cumulative `getMax`, whose tests are written before its implementation.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      list/
        List.java               # the List ADT contract (copied from the chapter)
      practice/
        BallColor.java          # the two ball colors
        Bag.java                # unordered collection; remove draws at random
        ArrayBag.java           # Bag with a seeded constructor
        PracticeMain.java       # demo entry point
        MaxList.java            # List<Integer> + getMax (cumulative max)
        MaxArrayList.java       # array-based MaxList (parallel max array)
        MaxLinkedList.java      # linked MaxList (per-node maxPointer)
    test/
      list/
        ListTest.java           # abstract: the List contract suite (copied from the chapter)
      practice/
        BagTest.java            # Bag contract tests (no internals)
        ArrayBagTest.java       # seeded, implementation-specific tests
        MaxListTest.java        # abstract: the inherited List tests plus the getMax tests
        MaxArrayListTest.java   # runs both suites against MaxArrayList
        MaxLinkedListTest.java  # runs both suites against MaxLinkedList
  scripts/
    run.sh                      # compile and run the Bag demo (practice.PracticeMain)
    test.sh                     # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ArrayBagTest` — compiles everything and runs only that test class. Use this while you are working on one problem and the other is still empty. For `MaxList`, use `practice.MaxArrayListTest` or `practice.MaxLinkedListTest`.
- `scripts/run.sh` — compiles everything and runs the `PracticeMain` demo.

## What's here

- `list.List` — the List ADT contract, copied from the chapter.
- `list.ListTest` — the abstract contract suite for `List`; a concrete subclass supplies the implementation.
- `practice.Bag` — an unordered bag of `BallColor` with `add`, `remove` (draws a ball uniformly at random, throws `IllegalStateException` when empty), and `size`.
- `practice.ArrayBag` — the same operations, plus a seeded constructor that makes its draws repeatable.
- `practice.BallColor` — the two-value enum the bag stores.
- `practice.PracticeMain` — a runnable demo of the bag.
- `practice.BagTest` — contract tests for `Bag` that hold on every random draw.
- `practice.ArrayBagTest` — implementation-specific tests that use a seeded `ArrayBag` to replay an exact sequence of draws.
- `practice.MaxList` — a `List<Integer>` with `getMax(index)`, the largest value among positions 0 through `index`.
- `practice.MaxArrayList` and `practice.MaxLinkedList` — the two `MaxList` implementations: an array with a parallel array of prefix maxima, and a linked list with a `maxPointer` per node.
- `practice.MaxListTest` — the abstract contract suite for `MaxList`. It extends `list.ListTest`, so every `List` test also runs against each `MaxList`.
