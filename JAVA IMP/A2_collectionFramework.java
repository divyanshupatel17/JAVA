/*
# COLLECTION->
    1. LIST
        1.1 ArrayList
        1.2 LinkedList
        1.3 Stack
        1.4 Vector     (less used)

    2. SET 
        2.1 EnumSet    (less used)
        2.2 HashSet
        2.3 LinkedHashSet
        2.4 TreeSet
        
    3. QUENE
        3.1 ArrayDeque
        3.2 LinkedList
        3.3 PriorityQuene    

# MAP ->
    1. HashMap
    2. TreeMap
    3. EnumMap         (less used)
    4. LinkedHashMap
    5. WeakHashMap     (less used)
    
# ITERATOR ->
    ListIterator       
*/

import java.util.*;
import java.lang.ref.WeakReference;  // for MAP

public class A2_collectionFramework {

    // 1. LIST

    public static void arrayListMethods() {
        ArrayList<String> list = new ArrayList<>();

        // 1.1.1 add(E e)
        list.add("Item 1"); // Adds "Item 1" to the list. Output: [Item 1]

        // 1.1.2 add(int index, E element)
        list.add(0, "Item 2"); // Inserts "Item 2" at index 0. Output: [Item 2, Item 1]

        // 1.1.3 addAll(Collection<? extends E> c)
        List<String> moreItems = Arrays.asList("Item 3", "Item 4");
        list.addAll(moreItems); // Adds all items from the collection. Output: [Item 2, Item 1, Item 3, Item 4]

        // 1.1.4 addAll(int index, Collection<? extends E> c)
        List<String> extraItems = Arrays.asList("Item 5", "Item 6");
        list.addAll(1, extraItems); // Inserts all items at index 1. Output: [Item 2, Item 5, Item 6, Item 1, Item 3, Item 4]

        // 1.1.5 clear()
        list.clear(); // Removes all elements from the list. Output: []

        // 1.1.6 clone()
        list.addAll(Arrays.asList("Item 7", "Item 8"));
        ArrayList<String> clonedList = (ArrayList<String>) list.clone(); // Creates a shallow copy of the list.

        // 1.1.7 contains(Object o)
        boolean containsItem = list.contains("Item 7"); // Checks if "Item 7" is in the list. Output: true

        // 1.1.8 ensureCapacity(int minCapacity)
        list.ensureCapacity(10); // Ensures the list can hold at least 10 elements.

        // 1.1.9 forEach(Consumer<? super E> action)
        list.forEach(System.out::println); // Iterates and prints each element.

        // 1.1.10 get(int index)
        String item = list.get(0); // Retrieves the element at index 0. Output: Item 7

        // 1.1.11 indexOf(Object o)
        int index = list.indexOf("Item 8"); // Returns the index of the first occurrence of "Item 8". Output: 1

        // 1.1.12 isEmpty()
        boolean isEmpty = list.isEmpty(); // Checks if the list is empty. Output: false

        // 1.1.13 iterator()
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // Iterates through the list.
        }

        // 1.1.14 lastIndexOf(Object o)
        list.add("Item 7");
        int lastIndex = list.lastIndexOf("Item 7"); // Returns the index of the last occurrence of "Item 7". Output: 2

        // 1.1.15 listIterator()
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next()); // Iterates through the list with a ListIterator.
        }

        // 1.1.16 remove(int index)
        list.remove(0); // Removes the element at index 0. Output: [Item 8, Item 7]

        // 1.1.17 remove(Object o)
        list.remove("Item 8"); // Removes the first occurrence of "Item 8". Output: [Item 7]

        // 1.1.18 removeAll(Collection<?> c)
        List<String> itemsToRemove = Arrays.asList("Item 7");
        list.removeAll(itemsToRemove); // Removes all elements found in the collection. Output: []

        // 1.1.19 removeIf(Predicate<? super E> filter)
        list.addAll(Arrays.asList("Item 9", "Item 10", "Item 11"));
        list.removeIf(element -> element.endsWith("0")); // Removes elements that satisfy the predicate. Output: [Item 9, Item 11]
        
        // 1.1.20 retainAll(Collection<?> c)
        List<String> itemsToRetain = Arrays.asList("Item 9");
        list.retainAll(itemsToRetain); // Retains only elements found in the collection. Output: [Item 9]

        // 1.1.21 set(int index, E element)
        list.set(0, "NewItem"); // Replaces the element at index 0 with "NewItem". Output: [NewItem]

        // 1.1.22 size()
        int size = list.size(); // Returns the number of elements in the list. Output: 1

        // 1.1.23 sort(Comparator<? super E> c)
        list.addAll(Arrays.asList("Item 12", "Item 13"));
        list.sort(String::compareTo); // Sorts the list in natural order. Output: [Item 12, Item 13, NewItem]

        // 1.1.24 subList(int fromIndex, int toIndex)
        List<String> subList = list.subList(0, 2); // Returns a sublist from index 0 to 2. Output: [Item 12, Item 13]

        // 1.1.25 toArray()
        Object[] array = list.toArray(); // Converts the list to an array. Output: [Item 12, Item 13, NewItem]

        // 1.1.26 toArray(T[] a)
        String[] stringArray = list.toArray(new String[0]); // Converts the list to a typed array. Output: [Item 12, Item 13, NewItem]

        // 1.1.27 trimToSize()
        list.trimToSize(); // Trims the capacity of the list to its current size.
    }

    public static void linkedListMethods() {
        LinkedList<String> list = new LinkedList<>();

        // 1.2.1 add(E e)
        list.add("Item 1"); // Adds "Item 1" to the end of the list. Output: [Item 1]

        // 1.2.2 add(int index, E element)
        list.add(0, "Item 2"); // Inserts "Item 2" at index 0. Output: [Item 2, Item 1]

        // 1.2.3 addAll(Collection<? extends E> c)
        list.addAll(Arrays.asList("Item 3", "Item 4")); // Adds all items from the collection. Output: [Item 2, Item 1, Item 3, Item 4]

        // 1.2.4 addAll(int index, Collection<? extends E> c)
        list.addAll(1, Arrays.asList("Item 5", "Item 6")); // Inserts all items at index 1. Output: [Item 2, Item 5, Item 6, Item 1, Item 3, Item 4]

        // 1.2.5 addFirst(E e)
        list.addFirst("First Item"); // Adds an element at the beginning. Output: [First Item, Item 2, Item 5, Item 6, Item 1, Item 3, Item 4]

        // 1.2.6 addLast(E e)
        list.addLast("Last Item"); // Adds an element at the end. Output: [First Item, Item 2, Item 5, Item 6, Item 1, Item 3, Item 4, Last Item]

        // 1.2.7 clear()
        list.clear(); // Removes all elements from the list. Output: []

        // Repopulate the list for further operations
        list.addAll(Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4"));

        // 1.2.8 clone()
        LinkedList<String> clonedList = (LinkedList<String>) list.clone(); // Creates a shallow copy of the list.

        // 1.2.9 contains(Object o)
        boolean containsItem = list.contains("Item 2"); // Checks if "Item 2" is in the list. Output: true

        // 1.2.10 descendingIterator()
        Iterator<String> descIterator = list.descendingIterator();
        while (descIterator.hasNext()) {
            System.out.println(descIterator.next()); // Iterates through the list in reverse order.
        }

        // 1.2.11 element()
        String firstElement = list.element(); // Retrieves, but does not remove, the first element. Output: Item 1

        // 1.2.12 get(int index)
        String item = list.get(2); // Retrieves the element at index 2. Output: Item 3

        // 1.2.13 getFirst()
        String firstItem = list.getFirst(); // Retrieves the first element. Output: Item 1

        // 1.2.14 getLast()
        String lastItem = list.getLast(); // Retrieves the last element. Output: Item 4

        // 1.2.15 indexOf(Object o)
        int index = list.indexOf("Item 2"); // Returns the index of the first occurrence of "Item 2". Output: 1

        // 1.2.16 lastIndexOf(Object o)
        list.add("Item 2");
        int lastIndex = list.lastIndexOf("Item 2"); // Returns the index of the last occurrence of "Item 2". Output: 4

        // 1.2.17 offer(E e)
        list.offer("New Item"); // Adds the specified element as the last element. Output: [Item 1, Item 2, Item 3, Item 4, Item 2, New Item]

        // 1.2.18 offerFirst(E e)
        list.offerFirst("First New Item"); // Inserts the specified element at the front. Output: [First New Item, Item 1, Item 2, Item 3, Item 4, Item 2, New Item]

        // 1.2.19 offerLast(E e)
        list.offerLast("Last New Item"); // Inserts the specified element at the end. Output: [First New Item, Item 1, Item 2, Item 3, Item 4, Item 2, New Item, Last New Item]

        // 1.2.20 peek()
        String peekedItem = list.peek(); // Retrieves, but does not remove, the first element. Output: First New Item

        // 1.2.21 peekFirst()
        String firstPeekedItem = list.peekFirst(); // Retrieves, but does not remove, the first element. Output: First New Item

        // 1.2.22 peekLast()
        String lastPeekedItem = list.peekLast(); // Retrieves, but does not remove, the last element. Output: Last New Item

        // 1.2.23 poll()
        String polledItem = list.poll(); // Retrieves and removes the first element. Output: First New Item

        // 1.2.24 pollFirst()
        String firstPolledItem = list.pollFirst(); // Retrieves and removes the first element. Output: Item 1

        // 1.2.25 pollLast()
        String lastPolledItem = list.pollLast(); // Retrieves and removes the last element. Output: Last New Item

        // 1.2.26 pop()
        String poppedItem = list.pop(); // Removes and returns the first element. Output: Item 2

        // 1.2.27 push(E e)
        list.push("Pushed Item"); // Inserts the element at the front. Output: [Pushed Item, Item 3, Item 4, Item 2, New Item]

        // 1.2.28 remove()
        String removedItem = list.remove(); // Removes and returns the first element. Output: Pushed Item

        // 1.2.29 remove(int index)
        String removedIndexItem = list.remove(1); // Removes the element at the specified position. Output: Item 4

        // 1.2.30 remove(Object o)
        boolean removed = list.remove("Item 2"); // Removes the first occurrence of the specified element. Output: true

        // 1.2.31 removeFirst()
        String removedFirstItem = list.removeFirst(); // Removes and returns the first element. Output: Item 3

        // 1.2.32 removeFirstOccurrence(Object o)
        list.add("New Item");
        boolean removedFirstOccurrence = list.removeFirstOccurrence("New Item"); // Removes the first occurrence of the specified element. Output: true

        // 1.2.33 removeLast()
        String removedLastItem = list.removeLast(); // Removes and returns the last element.

        // 1.2.34 removeLastOccurrence(Object o)
        list.add("Duplicate");
        list.add("Duplicate");
        boolean removedLastOccurrence = list.removeLastOccurrence("Duplicate"); // Removes the last occurrence of the specified element. Output: true

        // 1.2.35 set(int index, E element)
        list.set(0, "Updated Item"); // Replaces the element at the specified position. Output: [Updated Item, Duplicate]

        // 1.2.36 size()
        int size = list.size(); // Returns the number of elements in the list. Output: 2

        // 1.2.37 toArray()
        Object[] array = list.toArray(); // Converts the list to an array.

        // 1.2.38 toArray(T[] a)
        String[] stringArray = list.toArray(new String[0]); // Converts the list to a typed array.

        // Print the final state of the list
        System.out.println("Final list: " + list);
    }

    public static void stackMethods() {
        Stack<String> stack = new Stack<>();

        // 1.3.1 push(E item)
        stack.push("First"); // Pushes an item onto the top of the stack
        stack.push("Second");
        stack.push("Third");

        // 1.3.2 pop()
        String poppedItem = stack.pop(); // Removes and returns the top item. Output: Third

        // 1.3.3 peek()
        String topItem = stack.peek(); // Returns the top item without removing it. Output: Second

        // 1.3.4 empty()
        boolean isEmpty = stack.empty(); // Checks if the stack is empty. Output: false

        // 1.3.5 search(Object o)
        int position = stack.search("First"); // Returns the 1-based position from the top. Output: 2

        // 1.3.6 size()
        int size = stack.size(); // Returns the number of elements. Output: 2

        // 1.3.7 clear()
        stack.clear(); // Removes all elements from the stack

        System.out.println("Final stack: " + stack);
    }

    public static void vectorMethods() {
        Vector<String> vector = new Vector<>();

        // 1.4.1 add(E e)
        vector.add("First"); // Adds an element to the end
        vector.add("Second");

        // 1.4.2 add(int index, E element)
        vector.add(1, "Inserted"); // Inserts an element at the specified position

        // 1.4.3 addElement(E obj)
        vector.addElement("Third"); // Adds an element to the end (legacy method)

        // 1.4.4 capacity()
        int capacity = vector.capacity(); // Returns the current capacity

        // 1.4.5 clear()
        vector.clear(); // Removes all elements

        // Repopulate for further operations
        vector.addAll(Arrays.asList("A", "B", "C", "D"));

        // 1.4.6 clone()
        Vector<String> clonedVector = (Vector<String>) vector.clone(); // Creates a shallow copy

        // 1.4.7 contains(Object o)
        boolean contains = vector.contains("B"); // Checks if an element is present

        // 1.4.8 copyInto(Object[] anArray)
        String[] array = new String[vector.size()];
        vector.copyInto(array); // Copies elements into the specified array

        // 1.4.9 elementAt(int index)
        String element = vector.elementAt(2); // Returns the element at the specified index

        // 1.4.10 elements()
        Enumeration<String> elements = vector.elements(); // Returns an enumeration of the components

        // 1.4.11 ensureCapacity(int minCapacity)
        vector.ensureCapacity(10); // Increases the capacity if necessary

        // 1.4.12 firstElement()
        String first = vector.firstElement(); // Returns the first element

        // 1.4.13 get(int index)
        String item = vector.get(1); // Returns the element at the specified index

        // 1.4.14 indexOf(Object o)
        int index = vector.indexOf("C"); // Returns the index of the first occurrence

        // 1.4.15 insertElementAt(E obj, int index)
        vector.insertElementAt("Inserted", 2); // Inserts the specified element at the specified index

        // 1.4.16 isEmpty()
        boolean empty = vector.isEmpty(); // Checks if the vector is empty

        // 1.4.17 lastElement()
        String last = vector.lastElement(); // Returns the last element

        // 1.4.18 lastIndexOf(Object o)
        int lastIndex = vector.lastIndexOf("B"); // Returns the index of the last occurrence

        // 1.4.19 remove(int index)
        String removed = vector.remove(1); // Removes the element at the specified index

        // 1.4.20 removeElement(Object obj)
        boolean removed2 = vector.removeElement("C"); // Removes the first occurrence of the specified element

        // 1.4.21 removeElementAt(int index)
        vector.removeElementAt(0); // Removes the element at the specified index

        // 1.4.22 removeAllElements()
        vector.removeAllElements(); // Removes all elements

        // Repopulate for further operations
        vector.addAll(Arrays.asList("X", "Y", "Z"));

        // 1.4.23 setElementAt(E obj, int index)
        vector.setElementAt("New", 1); // Replaces the element at the specified index

        // 1.4.24 setSize(int newSize)
        vector.setSize(5); // Sets the size of the vector

        // 1.4.25 size()
        int size = vector.size(); // Returns the number of elements

        // 1.4.26 trimToSize()
        vector.trimToSize(); // Trims the capacity to the vector's current size

        System.out.println("Final vector: " + vector);
    }
 
    // 2. SET

    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void enumSetMethods() {
        System.out.println("EnumSet Methods:");

        // 2.1.1 allOf(Class<E> elementType)
        EnumSet<Days> allDays = EnumSet.allOf(Days.class);
        System.out.println("All days: " + allDays);

        // 2.1.2 noneOf(Class<E> elementType)
        EnumSet<Days> noDays = EnumSet.noneOf(Days.class);
        System.out.println("No days: " + noDays);

        // 2.1.3 of(E e)
        EnumSet<Days> oneDay = EnumSet.of(Days.MONDAY);
        System.out.println("One day: " + oneDay);

        // 2.1.4 of(E first, E... rest)
        EnumSet<Days> someDays = EnumSet.of(Days.SATURDAY, Days.SUNDAY);
        System.out.println("Some days: " + someDays);

        // 2.1.5 complementOf(EnumSet<E> s)
        EnumSet<Days> workDays = EnumSet.complementOf(someDays);
        System.out.println("Work days: " + workDays);

        // 2.1.6 copyOf(EnumSet<E> s)
        EnumSet<Days> copiedDays = EnumSet.copyOf(workDays);
        System.out.println("Copied days: " + copiedDays);

        // 2.1.7 range(E from, E to)
        EnumSet<Days> rangedDays = EnumSet.range(Days.MONDAY, Days.FRIDAY);
        System.out.println("Ranged days: " + rangedDays);

        // Common Set operations
        rangedDays.add(Days.SATURDAY);
        System.out.println("After adding Saturday: " + rangedDays);

        rangedDays.remove(Days.MONDAY);
        System.out.println("After removing Monday: " + rangedDays);

        boolean contains = rangedDays.contains(Days.WEDNESDAY);
        System.out.println("Contains Wednesday: " + contains);

        int size = rangedDays.size();
        System.out.println("Size of rangedDays: " + size);

        rangedDays.clear();
        System.out.println("After clearing: " + rangedDays);
    }

    public static void hashSetMethods() {
        System.out.println("\nHashSet Methods:");

        // 2.2.1 HashSet()
        HashSet<String> set = new HashSet<>();

        // 2.2.2 add(E e)
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        System.out.println("After adding elements: " + set);

        // 2.2.3 remove(Object o)
        boolean removed = set.remove("Banana");
        System.out.println("Banana removed: " + removed);
        System.out.println("After removal: " + set);

        // 2.2.4 contains(Object o)
        boolean contains = set.contains("Cherry");
        System.out.println("Contains Cherry: " + contains);

        // 2.2.5 size()
        int size = set.size();
        System.out.println("Size of set: " + size);

        // 2.2.6 isEmpty()
        boolean isEmpty = set.isEmpty();
        System.out.println("Is set empty: " + isEmpty);

        // 2.2.7 clear()
        set.clear();
        System.out.println("After clearing: " + set);

        // 2.2.8 addAll(Collection<? extends E> c)
        set.addAll(Arrays.asList("Dog", "Elephant", "Frog"));
        System.out.println("After adding all: " + set);

        // 2.2.9 removeAll(Collection<?> c)
        set.removeAll(Arrays.asList("Dog", "Frog"));
        System.out.println("After removing some: " + set);

        // 2.2.10 retainAll(Collection<?> c)
        set.retainAll(Arrays.asList("Elephant", "Giraffe"));
        System.out.println("After retaining: " + set);

        // 2.2.11 toArray()
        Object[] array = set.toArray();
        System.out.println("As array: " + Arrays.toString(array));

        // 2.2.12 iterator()
        Iterator<String> iterator = set.iterator();
        System.out.print("Iterating: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 2.2.13 HashSet(Collection<? extends E> c)
        HashSet<String> newSet = new HashSet<>(Arrays.asList("Hello", "World"));
        System.out.println("New set from collection: " + newSet);
    }

    public static void linkedHashSetMethods() {
        System.out.println("\nLinkedHashSet Methods:");

        // 2.3.1 LinkedHashSet()
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 2.3.2 add(E e)
        set.add("Red");
        set.add("Green");
        set.add("Blue");
        System.out.println("After adding elements: " + set);

        // 2.3.3 remove(Object o)
        boolean removed = set.remove("Green");
        System.out.println("Green removed: " + removed);
        System.out.println("After removal: " + set);

        // 2.3.4 contains(Object o)
        boolean contains = set.contains("Blue");
        System.out.println("Contains Blue: " + contains);

        // 2.3.5 size()
        int size = set.size();
        System.out.println("Size of set: " + size);

        // 2.3.6 isEmpty()
        boolean isEmpty = set.isEmpty();
        System.out.println("Is set empty: " + isEmpty);

        // 2.3.7 clear()
        set.clear();
        System.out.println("After clearing: " + set);

        // 2.3.8 addAll(Collection<? extends E> c)
        set.addAll(Arrays.asList("Yellow", "Orange", "Purple"));
        System.out.println("After adding all: " + set);

        // 2.3.9 removeAll(Collection<?> c)
        set.removeAll(Arrays.asList("Yellow", "Purple"));
        System.out.println("After removing some: " + set);

        // 2.3.10 retainAll(Collection<?> c)
        set.retainAll(Arrays.asList("Orange", "Black"));
        System.out.println("After retaining: " + set);

        // 2.3.11 toArray()
        Object[] array = set.toArray();
        System.out.println("As array: " + Arrays.toString(array));

        // 2.3.12 iterator()
        Iterator<String> iterator = set.iterator();
        System.out.print("Iterating: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 2.3.13 LinkedHashSet(Collection<? extends E> c)
        LinkedHashSet<String> newSet = new LinkedHashSet<>(Arrays.asList("Cat", "Dog"));
        System.out.println("New set from collection: " + newSet);
    }

    public static void treeSetMethods() {
        System.out.println("\nTreeSet Methods:");

        // 2.4.1 TreeSet()
        TreeSet<String> set = new TreeSet<>();

        // 2.4.2 add(E e)
        set.add("Zebra");
        set.add("Monkey");
        set.add("Giraffe");
        System.out.println("After adding elements: " + set);

        // 2.4.3 remove(Object o)
        boolean removed = set.remove("Monkey");
        System.out.println("Monkey removed: " + removed);
        System.out.println("After removal: " + set);

        // 2.4.4 contains(Object o)
        boolean contains = set.contains("Giraffe");
        System.out.println("Contains Giraffe: " + contains);

        // 2.4.5 size()
        int size = set.size();
        System.out.println("Size of set: " + size);

        // 2.4.6 isEmpty()
        boolean isEmpty = set.isEmpty();
        System.out.println("Is set empty: " + isEmpty);

        // 2.4.7 clear()
        set.clear();
        System.out.println("After clearing: " + set);

        // Repopulate the set
        set.addAll(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Fig"));

        // 2.4.8 first()
        String first = set.first();
        System.out.println("First element: " + first);

        // 2.4.9 last()
        String last = set.last();
        System.out.println("Last element: " + last);

        // 2.4.10 lower(E e)
        String lower = set.lower("Cherry");
        System.out.println("Element lower than Cherry: " + lower);

        // 2.4.11 higher(E e)
        String higher = set.higher("Cherry");
        System.out.println("Element higher than Cherry: " + higher);

        // 2.4.12 floor(E e)
        String floor = set.floor("D");
        System.out.println("Floor of D: " + floor);

        // 2.4.13 ceiling(E e)
        String ceiling = set.ceiling("D");
        System.out.println("Ceiling of D: " + ceiling);

        // 2.4.14 pollFirst()
        String pollFirst = set.pollFirst();
        System.out.println("Polled first element: " + pollFirst);
        System.out.println("Set after pollFirst: " + set);

        // 2.4.15 pollLast()
        String pollLast = set.pollLast();
        System.out.println("Polled last element: " + pollLast);
        System.out.println("Set after pollLast: " + set);

        // 2.4.16 descendingSet()
        NavigableSet<String> descendingSet = set.descendingSet();
        System.out.println("Descending set: " + descendingSet);

        // 2.4.17 subSet(E fromElement, E toElement)
        SortedSet<String> subSet = set.subSet("B", "D");
        System.out.println("Subset from B to D: " + subSet);

        // 2.4.18 headSet(E toElement)
        SortedSet<String> headSet = set.headSet("D");
        System.out.println("Head set before D: " + headSet);

        // 2.4.19 tailSet(E fromElement)
        SortedSet<String> tailSet = set.tailSet("C");
        System.out.println("Tail set from C: " + tailSet);
    }

    // 3. QUENE

    public static void arrayDequeMethod() {
        System.out.println("ArrayDeque Methods:");

        // 3.1.1 ArrayDeque()
        ArrayDeque<String> deque = new ArrayDeque<>();

        // 3.1.2 addFirst(E e)
        deque.addFirst("First");
        System.out.println("After addFirst: " + deque);

        // 3.1.3 addLast(E e)
        deque.addLast("Last");
        System.out.println("After addLast: " + deque);

        // 3.1.4 offerFirst(E e)
        boolean offered = deque.offerFirst("New First");
        System.out.println("offerFirst result: " + offered);
        System.out.println("After offerFirst: " + deque);

        // 3.1.5 offerLast(E e)
        offered = deque.offerLast("New Last");
        System.out.println("offerLast result: " + offered);
        System.out.println("After offerLast: " + deque);

        // 3.1.6 removeFirst()
        String removed = deque.removeFirst();
        System.out.println("removeFirst result: " + removed);
        System.out.println("After removeFirst: " + deque);

        // 3.1.7 removeLast()
        removed = deque.removeLast();
        System.out.println("removeLast result: " + removed);
        System.out.println("After removeLast: " + deque);

        // 3.1.8 pollFirst()
        String polled = deque.pollFirst();
        System.out.println("pollFirst result: " + polled);
        System.out.println("After pollFirst: " + deque);

        // 3.1.9 pollLast()
        polled = deque.pollLast();
        System.out.println("pollLast result: " + polled);
        System.out.println("After pollLast: " + deque);

        // Repopulate the deque
        deque.addAll(Arrays.asList("A", "B", "C", "D"));

        // 3.1.10 getFirst()
        String first = deque.getFirst();
        System.out.println("getFirst result: " + first);

        // 3.1.11 getLast()
        String last = deque.getLast();
        System.out.println("getLast result: " + last);

        // 3.1.12 peekFirst()
        String peeked = deque.peekFirst();
        System.out.println("peekFirst result: " + peeked);

        // 3.1.13 peekLast()
        peeked = deque.peekLast();
        System.out.println("peekLast result: " + peeked);

        // 3.1.14 removeFirstOccurrence(Object o)
        boolean removed2 = deque.removeFirstOccurrence("B");
        System.out.println("removeFirstOccurrence result: " + removed2);
        System.out.println("After removeFirstOccurrence: " + deque);

        // 3.1.15 removeLastOccurrence(Object o)
        removed2 = deque.removeLastOccurrence("C");
        System.out.println("removeLastOccurrence result: " + removed2);
        System.out.println("After removeLastOccurrence: " + deque);

        // 3.1.16 size()
        int size = deque.size();
        System.out.println("Size: " + size);

        // 3.1.17 isEmpty()
        boolean empty = deque.isEmpty();
        System.out.println("Is empty: " + empty);

        // 3.1.18 clear()
        deque.clear();
        System.out.println("After clear: " + deque);
    }

    public static void linkedListQueueMethods() {
        System.out.println("\nLinkedList as Queue Methods:");

        // 3.2.1 LinkedList()
        Queue<String> queue = new LinkedList<>();

        // 3.2.2 offer(E e)
        boolean offered = queue.offer("First");
        System.out.println("offer result: " + offered);
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("After offers: " + queue);

        // 3.2.3 poll()
        String polled = queue.poll();
        System.out.println("poll result: " + polled);
        System.out.println("After poll: " + queue);

        // 3.2.4 peek()
        String peeked = queue.peek();
        System.out.println("peek result: " + peeked);

        // 3.2.5 element()
        String element = queue.element();
        System.out.println("element result: " + element);

        // 3.2.6 remove()
        String removed = queue.remove();
        System.out.println("remove result: " + removed);
        System.out.println("After remove: " + queue);

        // 3.2.7 size()
        int size = queue.size();
        System.out.println("Size: " + size);

        // 3.2.8 isEmpty()
        boolean empty = queue.isEmpty();
        System.out.println("Is empty: " + empty);

        // 3.2.9 clear()
        queue.clear();
        System.out.println("After clear: " + queue);
    }

    public static void priorityQueueMethods() {
        System.out.println("\nPriorityQueue Methods:");

        // 3.3.1 PriorityQueue()
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3.3.2 offer(E e)
        pq.offer(5);
        pq.offer(2);
        pq.offer(8);
        pq.offer(1);
        System.out.println("After offers: " + pq);

        // 3.3.3 poll()
        Integer polled = pq.poll();
        System.out.println("poll result: " + polled);
        System.out.println("After poll: " + pq);

        // 3.3.4 peek()
        Integer peeked = pq.peek();
        System.out.println("peek result: " + peeked);

        // 3.3.5 remove()
        Integer removed = pq.remove();
        System.out.println("remove result: " + removed);
        System.out.println("After remove: " + pq);

        // 3.3.6 element()
        Integer element = pq.element();
        System.out.println("element result: " + element);

        // 3.3.7 size()
        int size = pq.size();
        System.out.println("Size: " + size);

        // 3.3.8 isEmpty()
        boolean empty = pq.isEmpty();
        System.out.println("Is empty: " + empty);

        // 3.3.9 clear()
        pq.clear();
        System.out.println("After clear: " + pq);

        // 3.3.10 PriorityQueue(Comparator<? super E> comparator)
        PriorityQueue<String> customPQ = new PriorityQueue<>((a, b) -> b.length() - a.length());
        customPQ.addAll(Arrays.asList("short", "very long", "medium"));
        System.out.println("Custom PriorityQueue: " + customPQ);
        System.out.println("Poll from custom PQ: " + customPQ.poll());
    }


    // MAP

    // enum Days {
    //     MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    // }

    public static void hashMapMethods() {
        System.out.println("HashMap Methods:");

        // 1.1 HashMap()
        HashMap<String, Integer> map = new HashMap<>();

        // 1.2 put(K key, V value)
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println("After puts: " + map);

        // 1.3 get(Object key)
        Integer value = map.get("Two");
        System.out.println("get('Two'): " + value);

        // 1.4 remove(Object key)
        Integer removed = map.remove("Three");
        System.out.println("remove('Three'): " + removed);
        System.out.println("After remove: " + map);

        // 1.5 containsKey(Object key)
        boolean containsKey = map.containsKey("One");
        System.out.println("containsKey('One'): " + containsKey);

        // 1.6 containsValue(Object value)
        boolean containsValue = map.containsValue(2);
        System.out.println("containsValue(2): " + containsValue);

        // 1.7 size()
        int size = map.size();
        System.out.println("Size: " + size);

        // 1.8 isEmpty()
        boolean empty = map.isEmpty();
        System.out.println("Is empty: " + empty);

        // 1.9 clear()
        map.clear();
        System.out.println("After clear: " + map);

        // Repopulate the map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // 1.10 keySet()
        Set<String> keys = map.keySet();
        System.out.println("Keys: " + keys);

        // 1.11 values()
        Collection<Integer> values = map.values();
        System.out.println("Values: " + values);

        // 1.12 entrySet()
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("Entries: " + entries);

        // 1.13 putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("D", 4);
        newMap.put("E", 5);
        map.putAll(newMap);
        System.out.println("After putAll: " + map);

        // 1.14 getOrDefault(Object key, V defaultValue)
        Integer defaultValue = map.getOrDefault("F", 0);
        System.out.println("getOrDefault('F', 0): " + defaultValue);

        // 1.15 putIfAbsent(K key, V value)
        map.putIfAbsent("C", 30);
        map.putIfAbsent("G", 7);
        System.out.println("After putIfAbsent: " + map);
    }

    public static void treeMapMethods() {
        System.out.println("\nTreeMap Methods:");

        // 2.1 TreeMap()
        TreeMap<String, Integer> map = new TreeMap<>();

        // 2.2 put(K key, V value)
        map.put("B", 2);
        map.put("A", 1);
        map.put("C", 3);
        System.out.println("After puts: " + map);

        // 2.3 get(Object key)
        Integer value = map.get("B");
        System.out.println("get('B'): " + value);

        // 2.4 remove(Object key)
        Integer removed = map.remove("C");
        System.out.println("remove('C'): " + removed);
        System.out.println("After remove: " + map);

        // 2.5 firstKey()
        String firstKey = map.firstKey();
        System.out.println("First key: " + firstKey);

        // 2.6 lastKey()
        String lastKey = map.lastKey();
        System.out.println("Last key: " + lastKey);

        // Repopulate the map
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        // 2.7 lowerKey(K key)
        String lowerKey = map.lowerKey("C");
        System.out.println("Lower key of 'C': " + lowerKey);

        // 2.8 higherKey(K key)
        String higherKey = map.higherKey("C");
        System.out.println("Higher key of 'C': " + higherKey);

        // 2.9 floorKey(K key)
        String floorKey = map.floorKey("C");
        System.out.println("Floor key of 'C': " + floorKey);

        // 2.10 ceilingKey(K key)
        String ceilingKey = map.ceilingKey("C");
        System.out.println("Ceiling key of 'C': " + ceilingKey);

        // 2.11 pollFirstEntry()
        Map.Entry<String, Integer> firstEntry = map.pollFirstEntry();
        System.out.println("Polled first entry: " + firstEntry);
        System.out.println("After pollFirstEntry: " + map);

        // 2.12 pollLastEntry()
        Map.Entry<String, Integer> lastEntry = map.pollLastEntry();
        System.out.println("Polled last entry: " + lastEntry);
        System.out.println("After pollLastEntry: " + map);

        // 2.13 subMap(K fromKey, K toKey)
        SortedMap<String, Integer> subMap = map.subMap("B", "D");
        System.out.println("SubMap from 'B' to 'D': " + subMap);

        // 2.14 headMap(K toKey)
        SortedMap<String, Integer> headMap = map.headMap("D");
        System.out.println("HeadMap before 'D': " + headMap);

        // 2.15 tailMap(K fromKey)
        SortedMap<String, Integer> tailMap = map.tailMap("C");
        System.out.println("TailMap from 'C': " + tailMap);
    }

    public static void enumMapMethods() {
        System.out.println("\nEnumMap Methods:");

        // 3.1 EnumMap(Class<K> keyType)
        EnumMap<Days, String> map = new EnumMap<>(Days.class);

        // 3.2 put(K key, V value)
        map.put(Days.MONDAY, "Start of week");
        map.put(Days.FRIDAY, "End of week");
        System.out.println("After puts: " + map);

        // 3.3 get(Object key)
        String value = map.get(Days.MONDAY);
        System.out.println("get(MONDAY): " + value);

        // 3.4 remove(Object key)
        String removed = map.remove(Days.FRIDAY);
        System.out.println("remove(FRIDAY): " + removed);
        System.out.println("After remove: " + map);

        // 3.5 containsKey(Object key)
        boolean containsKey = map.containsKey(Days.MONDAY);
        System.out.println("containsKey(MONDAY): " + containsKey);

        // 3.6 containsValue(Object value)
        boolean containsValue = map.containsValue("Start of week");
        System.out.println("containsValue('Start of week'): " + containsValue);

        // 3.7 size()
        int size = map.size();
        System.out.println("Size: " + size);

        // 3.8 clear()
        map.clear();
        System.out.println("After clear: " + map);

        // 3.9 putAll(Map<? extends K, ? extends V> m)
        Map<Days, String> newMap = new HashMap<>();
        newMap.put(Days.TUESDAY, "Second day");
        newMap.put(Days.WEDNESDAY, "Middle of week");
        map.putAll(newMap);
        System.out.println("After putAll: " + map);
    }

    public static void linkedHashMapMethods() {
        System.out.println("\nLinkedHashMap Methods:");

        // 4.1 LinkedHashMap()
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // 4.2 put(K key, V value)
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println("After puts: " + map);

        // 4.3 get(Object key)
        Integer value = map.get("B");
        System.out.println("get('B'): " + value);

        // 4.4 remove(Object key)
        Integer removed = map.remove("C");
        System.out.println("remove('C'): " + removed);
        System.out.println("After remove: " + map);

        // 4.5 containsKey(Object key)
        boolean containsKey = map.containsKey("A");
        System.out.println("containsKey('A'): " + containsKey);

        // 4.6 containsValue(Object value)
        boolean containsValue = map.containsValue(2);
        System.out.println("containsValue(2): " + containsValue);

        // 4.7 size()
        int size = map.size();
        System.out.println("Size: " + size);

        // 4.8 clear()
        map.clear();
        System.out.println("After clear: " + map);

        // 4.9 LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
        map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.get("A");  // This will move "A" to the end
        System.out.println("After access-ordered get: " + map);

        // 4.10 eldest entry removal
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<String, Integer>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 3;
            }
        };
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        lruCache.put("D", 4);  // This will cause "A" to be removed
        System.out.println("LRU Cache after fourth insert: " + lruCache);
    }

    public static void weakHashMapMethods() {
        System.out.println("\nWeakHashMap Methods:");

        // 5.1 WeakHashMap()
        WeakHashMap<Object, String> map = new WeakHashMap<>();

        // 5.2 put(K key, V value)
        Object key1 = new Object();
        Object key2 = new Object();
        map.put(key1, "Value 1");
        map.put(key2, "Value 2");
        System.out.println("After puts: " + map);

        // 5.3 get(Object key)
        String value = map.get(key1);
        System.out.println("get(key1): " + value);

        // 5.4 remove(Object key)
        String removed = map.remove(key2);
        System.out.println("remove(key2): " + removed);
        System.out.println("After remove: " + map);

        // 5.5 containsKey(Object key)
        boolean containsKey = map.containsKey(key1);
        System.out.println("containsKey(key1): " + containsKey);

        // 5.6 containsValue(Object value)
        boolean containsValue = map.containsValue("Value 1");
        System.out.println("containsValue('Value 1'): " + containsValue);

        // 5.7 size()
        int size = map.size();
        System.out.println("Size: " + size);

        // 5.8 clear()
        map.clear();
        System.out.println("After clear: " + map);

        // Demonstrate weak reference behavior
        Object weakKey = new Object();
        map.put(weakKey, "Weak Value");
        System.out.println("Before GC: " + map);
        
        weakKey = null;
        System.gc();  // Encourage garbage collection
        
        // The entry might be removed after GC, but this is not guaranteed
        System.out.println("After GC: " + map);
    }


    // ITERATOR
    public static void iteratorMethods() {
        System.out.println("\nIterator Methods:");
    
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        Iterator<String> iterator = list.iterator();
    
        // 1. hasNext()
        System.out.println("Has next element: " + iterator.hasNext());
    
        // 2. next()
        System.out.println("Next element: " + iterator.next());
    
        // 3. remove()
        iterator.remove();
        System.out.println("After removing the last returned element: " + list);
    
        // Iterate through all elements
        System.out.print("Iterating through all elements: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    
        // ListIterator (which extends Iterator)
        System.out.println("\nListIterator Methods:");
        ListIterator<String> listIterator = list.listIterator();
    
        // 4. hasPrevious()
        System.out.println("Has previous element: " + listIterator.hasPrevious());
    
        // Move to the end of the list
        while (listIterator.hasNext()) {
            listIterator.next();
        }
    
        // 5. previous()
        System.out.println("Previous element: " + listIterator.previous());
    
        // 6. nextIndex()
        System.out.println("Next index: " + listIterator.nextIndex());
    
        // 7. previousIndex()
        System.out.println("Previous index: " + listIterator.previousIndex());
    
        // 8. set(E e)
        listIterator.set("X");
        System.out.println("After setting the last returned element to 'X': " + list);
    
        // 9. add(E e)
        listIterator.add("Y");
        System.out.println("After adding 'Y': " + list);
    }

// MAIN METHOD

    public static void main(String[] args) {
                //         # COLLECTION->
                //     1. LIST
                //         1.1 ArrayList
                                arrayListMethods();
                //         1.2 LinkedList
                                linkedListMethods();
                //         1.3 Stack
                                stackMethods();
                //         1.4 Vector     (less used)
                                vectorMethods();

                //     2. SET 
                //         2.1 EnumSet    (less used)
                                enumSetMethods();
                //         2.2 HashSet
                                hashSetMethods();
                //         2.3 LinkedHashSet
                                linkedHashSetMethods();
                //         2.4 TreeSet
                                treeSetMethods();
                        
                //     3. QUENE
                //         3.1 ArrayDeque
                                arrayDequeMethod();
                //         3.2 LinkedList
                                linkedListQueueMethods();
                //         3.3 PriorityQuene    
                                priorityQueueMethods();

                // # MAP ->
                //     1. HashMap
                                hashMapMethods();
                //     2. TreeMap
                                treeMapMethods();
                //     3. EnumMap         (less used)
                                enumMapMethods();
                //     4. LinkedHashMap
                                linkedHashMapMethods();
                //     5. WeakHashMap     (less used)
                                weakHashMapMethods();
                    
                // # ITERATOR ->
                //     ListIterator
                                iteratorMethods();
    }
}
