# Testing — Practice: The Bag

A `Bag` of colored balls whose `remove` draws a ball at random, so its tests check invariants instead of exact outputs.

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
      practice/
        BallColor.java     # the two ball colors
        Bag.java            # unordered collection; remove draws at random
        ArrayBag.java       # Bag with a seeded constructor
        PracticeMain.java   # demo entry point
    test/
      practice/
        BagTest.java        # Bag contract tests (no internals)
        ArrayBagTest.java   # seeded, implementation-specific tests
  scripts/
    run.sh                  # compile and run the Bag demo (practice.PracticeMain)
    test.sh                 # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ArrayBagTest` — compiles everything and runs only that test class.
- `scripts/run.sh` — compiles everything and runs the `PracticeMain` demo.

## What's here

- `practice.Bag` — an unordered bag of `BallColor` with `add`, `remove` (draws a ball uniformly at random, throws `IllegalStateException` when empty), and `size`.
- `practice.ArrayBag` — the same operations, plus a seeded constructor that makes its draws repeatable.
- `practice.BallColor` — the two-value enum the bag stores.
- `practice.PracticeMain` — a runnable demo of the bag.
- `practice.BagTest` — contract tests for `Bag` that hold on every random draw.
- `practice.ArrayBagTest` — implementation-specific tests that use a seeded `ArrayBag` to replay an exact sequence of draws.
