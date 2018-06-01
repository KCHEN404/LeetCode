# Hashing
1. Hash Function
    1. Key mod TableSize
        1. it is often a good idea to ensure that the table size is prime
        2. for string: not well when table size is too large
    2. Element Collision
        1. Separate Chaining
            - keep a list of all elements that hash to the same value
    3. Hashcode and Equals
    4. Load Factor λ
        - the ratio of the number of elements in the hash table to the table size
2. Hash Tables without Linked Lists
    1. generally, the load factor should be below λ = 0.5 for a hash table that doesn’t use separate chaining, which is called probing hash table
    2. Linear Probing
        1. trying cells sequentially (with wraparound) in search of an empty cell
        2. primary clustering
            - any key that hashes into the cluster will require several attempts to resolve the collision, and then it will add to the cluster
    3. Quadratic Probing 