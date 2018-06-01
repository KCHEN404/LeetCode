# Hashing
1. Hash Function
    1. Key mod TableSize
        1. it is often a good idea to ensure that the table size is prime
        2. for string: not well when table size is too large
    2. Element Collision
        1. Separate Chaining
            - keep a list of all elements that hash to the same value
    3. HashCode and Equals
    4. Load Factor λ
        - the ratio of the number of elements in the hash table to the table size
2. Hash Tables without Linked Lists
    1. generally, the load factor should be below λ = 0.5 for a hash table that doesn’t use separate chaining, which is called probing hash table
    2. Linear Probing
        1. H: collision, next try: H+1, H+2, H+3...
        2. Better cache performance than quadratic probing (locality)
        3. primary clustering
            - any key that hashes into the cluster will require several attempts to resolve the collision, and then it will add to the cluster
    3. Quadratic Probing
        1. eliminates the primary clustering problem of linear probing
        2. H: collision, next try: H+1, H+2^2, H+3^2...
        3. Secondary Clustering
            - elements that hash to the same position will probe the same alternative cells
    4. Double Hashing
        1. reduce primary and secondary clustering
            - ex: f(i) = i · hash2(x) 
                - apply a second hash function to x and probe at a distance hash2(x), 2hash2(x), ... , and so on
        2. the function must never evaluate to zero
        3. it is also important to make sure all cells can be probed
3. Rehashing
    1. expensive
        1. rehash when half of the table is full
        2. rehash when an insertion fails
        3. rehash when a certain load factor is reached (best strategy)
4. Hash Tables in Standard Library
    1. HashMap
    2. HashSet
    3. both use separate chaining
    4. for string: caching the hash code
        1. works only because Strings are immutable, if the String were allowed to change, it would invalidate the hashCode
    5. can expect O(1) cost on average for insertions, removes, and searching
5. Perfect Hashing
    1. no collisions
    2. static dictionary