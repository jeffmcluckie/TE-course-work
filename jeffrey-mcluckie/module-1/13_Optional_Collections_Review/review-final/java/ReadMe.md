# Collections Review

## Collections Framework in Java

- Collection Interface, with subinterfaces List, Set, etc
- Map is also considered a part of the collections framework, but is a separate interface

- Similarities & differences
    - ordered? 
    - allow null?
    - allow duplicates?
    - operations available
    - need key/value pair look for a Map
    
### Lists

    - Ordered
    - Typically allow dups
    - May allow nulls, check concrete class

#### Array List
Did some basic operations in the review Main...

### Sets
 
  - Some are ordered, some not (check concrete class)
  - No dups 
  - some allow nulls, some do not

#### TreeSet
  - This is ordered

#### Maps

  - Key & Value pairs
  - Does not implement Collection interface
    - This means that we have put vs add to insert an item
    - BUT is still considered a Collection Framework type
  - No duplicate keys, put with same key updates item

#### HashMap

  - Basic Map type
  - Iteration order is NOT guaranteed

#### LinkedHashMap

  - Iteration order IS guaranteed

#### TreeMap

  - Ordered by "natural order" or Comparator
  - Comparator can be provided in constructor

  - Question on solving Collections Part 2 animalGroupName function with this type of Map
    - Use a case insensitive Comparator when creating the TreeMap
    - Then key is not case sensitive!

    