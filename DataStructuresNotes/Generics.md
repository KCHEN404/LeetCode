# Generics
1. Why Generics?
    1. Strong type check
    2. Enabling programmers to implement generic algorithms.
2. Definition
    1. A generic type is a generic class or interface that is parameterized over types
    2. Ex: class name<T1, T2, ..., Tn> { /* ... */ }
        1. public class Box<T>
    3. generic type invocation
        1. Box<Integer> integerBox;
    4. instantiate this class
        1. Box<Integer> integerBox = new Box<Integer>();
3. Raw Types
    1. A raw type is the name of a generic class or interface without any type arguments.
    2. Ex: Box rawBox = new Box();
    3. Note: a non-generic class or interface type is not a raw type
4. Generic Methods
    1. Generic methods are methods that introduce their own type parameters
5. Bounded Type Parameters