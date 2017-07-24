Codility Lessons
==============
I share my Java solutions to Codility's Lessons here. 
The lessons are on Codility.com [here](https://codility.com/programmers/lessons/)  
These solutions have the emphasis on readability.

So instead of writing

```Java
    if ((N >> i & mask) == 1) {
       ...
    }
```

I would use

```java
    // shift the current bit to the right most bit
    int currentN = N >> i;
    
    // and extract the right most bit
    int rightMostBit = currentN & mask;
    
    if (rightMostBit == 1) {
        ...
    }
```

The Java compiler is able to easily optimize such readability formatting.

