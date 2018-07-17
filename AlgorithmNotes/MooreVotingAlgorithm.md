# Moore Voting Algorithm
1. an algorithm for finding the majority of a sequence of elements using linear time and constant space
    1. a counter initially zero
    2. processes the elements of the sequence, one at a time (element x)
        1.  if the counter is zero, the algorithm stores x as its remembered sequence element and sets the counter to one
        2.  Otherwise, it compares x to the stored element
            1.  increments the counter (if they are equal)
            2.  decrements the counter (otherwise)