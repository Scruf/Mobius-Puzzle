![](https://www.cs.rit.edu/~csci242/Projects/Puzzles/mobius1.jpg)

Project Part 1: Mobius
----------------------

##### Revisions:\

*Start now!*
------------

### Overview

The first puzzle you will solve is the Mobius Puzzle. Recall that a
mobius strip is a device that only has one side (except for the edge)
which forms a continuous loop. For our puzzle, imagine that you have
written numbers on the mobius strip. As you write enough numbers,
eventually they run up to the starting number. For our puzzle we will
write a program that will "find" a number on the mobius strip. There are
three parameters associated with the mobius puzzle:

-   The *range* of numbers, an integer N. N will be a number \> 0
-   The *start number*, an integer from 1..N
-   The *goal number*, an integer from 1..N

*Start now!*
------------

### Requirements

The program is run from the command line as:\
\

`% java Mobius {range} {start} {goal}`

Your program will display, to standard output, the shortest number of
steps it takes to get from the start to the goal. The steps must be
numbered starting from 0 (the starting step), up to the goal step. For
example:\
\

`     % java Mobius 15 2 14     Step 0: 2     Step 1: 1     Step 2: 15     Step 3: 14`

Note: your output must match the format specified here, part of your
grade will be made up of correctly formatted output.

If the number of arguments are incorrect, you should display a usage
message to standard output and exit. For example:\
\
 `     % java Mobius     Usage: java Mobius range start goal`

For this puzzle, we guarantee that if the number of arguments is
correct, they will all be positive integers between 1.. N.

*Start now!*
------------

### Design

In order to receive full credit for this assignment, you must abide by
these design standards:

-   Using the provided
    [Puzzle](https://www.cs.rit.edu/~csci242/Projects/Puzzles/docs/Puzzle.html)
    interface, you will implement this interface from scratch.
-   You will write, from scratch, a `Mobius` class. It has the `main`
    function. In addition, it implements the
    [Puzzle](https://www.cs.rit.edu/~csci242/Projects/Puzzles/docs/Puzzle.html)
    interface routines.
-   You will write, from scratch, a `Solver` class. This class takes
    your `Mobius` object, as a `Puzzle` interface, and uses it to solve
    the puzzle using the algorithm described below.

### Naive BFS Solver

You've probably realized that *this* puzzle can be solved using a simple
mathematical formula. We call this a *heuristic*. However, the key
requirement of this project is that you have one solver that can solve
*any* puzzle. Because all puzzles can't be solved with the same
heuristic, you are not allowed to use this approach.

Instead, we are going to revisit the shortest path algorithm that we
have previously discussed. Recall that if you know the start and goal
configuration, and you have a way to generate the neighbors of any
configuration, you can use the BFS algorithm to find the shortest path
between them.

Here is the
[pseudocode](https://www.cs.rit.edu/~csci242/Projects/Puzzles/naive_bfs.txt)
for a naive BFS Solver.

The naive solver has many limitations right now. We will use the
[ArrayList](http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html)
(for example, to represent the queue, and also the individual
configurations). **You are required to implement this part using only
the `ArrayList` collection.** After this part is finished, you are free
to modify it to use whatever collection classes you desire.

Another thing you will notice with the solver is that it doesn't
determine the shortest path in the traditional manner. Each
configuration contains the entire path from the starting config to the
current one. The last element in the config is the one used to generate
the next neighbors. A config whose last element is the goal is the
solution.

Another major downside to this approach is that it will not be able to
compute very long solutions. Once you go beyond 20 or so steps, the
search space expands too rapidly to compute a solution in a feasible
amount of time. We will fix this problem in the next part, so assume for
now that we will not test with solutions that are more than 20 steps.
