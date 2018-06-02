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
    3. two-level hashing
    4. dynamic perfect hashing allows insertion and deletion, very expensive though
6. Cuckoo Hashing
    1. alternative for dynamic perfect hashing
    2. two tables with more than half of the table empty
        1. if position in table 1 is taken, can either replace item in table 1 or take a look at table 2
7. Hopscotch Hashing
    1. The algorithm uses a single array of n buckets. For each bucket, its neighborhood is a small collection of nearby consecutive buckets (i.e. ones with close indices to the original hashed bucket).
        1. If the entry i is empty, add x to i and return.
        2. Starting at entry i, use a linear probe to find an empty entry at index j.
        3. If the empty entry's index j is within H-1 of entry i, place x there and return. Otherwise, create an empty entry closer to i, find an item y whose hash value lies between i and j, but within H-1 of j. Displacing y to j creates a new empty slot closer to i. Repeat until the empty entry is within H-1 of entry i, place x there and return. If no such item y exists, or if the bucket i already contains H items, resize and rehash the table.
8. Universal Hashing
    1. Two properties
        1. The hash function must be computable in constant time (i.e., independent of the number of items in the hash table
        2. The hash function must distribute its items uniformly among the array slots.
    2. The probability of a collision between any two distinct items is at most 1/M
9. Extensible Hashing
    1. a type of hash system which treats a hash as a bit string, and uses a trie for bucket lookup. Because of the hierarchical nature of the system, re-hashing is an incremental operation (done one bucket at a time, as needed). This means that time-sensitive applications are less affected by table growth than by standard full-table rehashes.