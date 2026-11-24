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
        Bag.java                # the Bag ADT: add, remove (a random draw), size
        ArrayBag.java           # array-backed Bag, with a seeded constructor
        MaxList.java            # List<Integer> + getMax (cumulative max)
        MaxArrayList.java       # array-based MaxList (parallel max array)
        MaxLinkedList.java      # linked MaxList (per-node maxPointer)
      demo/                     # one demo per class
        BagDemo.java
        MaxArrayListDemo.java
        MaxLinkedListDemo.java
    test/
      list/
        ListTest.java           # abstract: the List contract suite (copied from the chapter)
      practice/
        BagTest.java            # abstract: the Bag contract suite
        ArrayBagTest.java       # runs BagTest against ArrayBag, plus seeded tests
        MaxListTest.java        # abstract: the inherited List tests plus the getMax tests
        MaxArrayListTest.java   # runs both suites against MaxArrayList
        MaxLinkedListTest.java  # runs both suites against MaxLinkedList
  scripts/
    test.sh                     # compile and run every JUnit test
    run.sh                      # compile and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ArrayBagTest` — compiles everything and runs only that test class. Use this while you are working on one problem and the other is still empty. For `MaxList`, use `practice.MaxArrayListTest` or `practice.MaxLinkedListTest`.
- `scripts/run.sh demo.MaxArrayListDemo` — compiles everything and runs that one demo. Every class you implement has its own demo, `<Class>Demo`.

## Contents

- `list.List` — the List ADT contract, copied from the chapter.
- `list.ListTest` — the abstract contract suite for `List`; a concrete subclass supplies the implementation.
- `practice.Bag` — the Bag ADT: an unordered bag of `BallColor` with `add`, `remove` (draws a ball uniformly at random, throws `IllegalStateException` when empty), and `size`.
- `practice.ArrayBag` — the array-backed implementation of `Bag`, plus a seeded constructor that makes its draws repeatable.
- `practice.BallColor` — the two-value enum the bag stores.
- `practice.BagTest` — the abstract contract suite for `Bag`; its tests hold on every random draw, and a concrete subclass supplies the implementation.
- `practice.ArrayBagTest` — runs the contract suite against `ArrayBag`, and adds implementation-specific tests that use a seeded `ArrayBag` to replay an exact sequence of draws.
- `practice.MaxList` — a `List<Integer>` with `getMax(index)`, the largest value among positions 0 through `index`.
- `practice.MaxArrayList` and `practice.MaxLinkedList` — the two `MaxList` implementations: an array with a parallel array of prefix maxima, and a linked list with a `maxPointer` per node.
- `practice.MaxListTest` — the abstract contract suite for `MaxList`. It extends `list.ListTest`, so every `List` test also runs against each `MaxList`.
- `demo.BagDemo`, `demo.MaxArrayListDemo`, and `demo.MaxLinkedListDemo` — one demo per class, each on an example from the notes.
