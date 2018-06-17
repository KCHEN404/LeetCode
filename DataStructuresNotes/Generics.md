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
    1. to restrict the types that can be used as type arguments in a parameterized type
        1. Ex: public <U extends Number> void inspect(U u)
6. Multiple Bounds
    1. <T extends B1 & B2 & B3>
7. Generics, Inheritance, and Subtypes
    1. Given two concrete types A and B (for example, Number and Integer), MyClass<A> has no relationship to MyClass<B>, regardless of whether or not A and B are related. The common parent of MyClass<A> and MyClass<B> is Object.
    2. Generic Classes and Subtyping
        1. ArrayList<E> implements List<E>, and List<E> extends Collection<E>. So ArrayList<String> is a subtype of List<String>, which is a subtype of Collection<String>. So long as you do not vary the type argument, the subtyping relationship is preserved between the types.
8. Type Inference
    1. You can replace the type arguments required to invoke the constructor of a generic class with an empty set of type parameters (<>) as long as the compiler can infer the type arguments from the context.
    2. Target Types
        1. The target type of an expression is the data type that the Java compiler expects depending on where the expression appears. 
9. Wildcards
    1. the question mark (?), called the wildcard, represents an unknown type 
    2. Upper Bounded Wildcards
        1. to relax the restrictions on a variable
            1. To declare an upper-bounded wildcard, use the wildcard character ('?'), followed by the extends keyword, followed by its upper bound. Note that, in this context, extends is used in a general sense to mean either "extends" (as in classes) or "implements" (as in interfaces).
                1. Ex: The upper bounded wildcard, <? extends Foo>, where Foo is any type, matches Foo and any subtype of Foo