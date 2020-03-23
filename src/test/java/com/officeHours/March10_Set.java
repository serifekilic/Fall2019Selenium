package com.officeHours;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.*;

public class March10_Set {

    public static void main(String[] args) {

        /*
        under List Interface:
        -ArrayList(indexes, faster to read, slower when we do some manipulations(=remove or add elements))
        _Vector( same as ArrayList, but thread safe)
            -Stack(we can say stack of paper, and we want to get one, we take from top)
                    (LIFO=last in first out)
        -LinkedList (node (each element reference  to previous and next element in the list)
        (Performance -sensitive, memory allocation)

        [2,5,3]-- arraylist
        [2] [5]  [3]---linkedList


        Set Interface (contain only unique values)
        HashSet : no indexes- faster bec, it is using hashing
        (it does not keep an order), allows one null value
        LinkedHashSet : keeps the order
        TreeSet : sorted set - no nulls


         */
        HashSet <String> hashSet = new HashSet<>();
        TreeSet <String> treeSet = new TreeSet<>();
        LinkedHashSet <String> linkedHashSet = new LinkedHashSet<>();
        for (String each : Arrays.asList("Value5", "Value1", "Value3")){
            hashSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);
        }
        System.out.println("hashset: " + hashSet);
        System.out.println("treeset: " + treeSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        Iterator <String> iteratorSet = hashSet.iterator();
        while (iteratorSet.hasNext()){
            System.out.println(iteratorSet.next());
        }
        ArrayList<Integer> dropdown = new ArrayList<>();
        dropdown.add(1);
        dropdown.add(2);
        dropdown.add(3);
        dropdown.add(4);
        dropdown.add(5);
        dropdown.add(1);
        //[1, 2, 3, 4, 5, 1]
        System.out.println("list: " + dropdown);
        HashSet <Integer> optionsSet = new HashSet<>(dropdown);
        System.out.println("optionSet: " + optionsSet);
        if (optionsSet.size() == dropdown.size()){
            System.out.println("expected is the same as actual");
        }else {
            System.out.println("options contains duplicates");
        }
        //=========================
        /*
            Queue:
            - PriorityQueue - First in first out
                can accept duplicates, does not have index
            - ArrayDequeue - special in adding and removing
         */
        PriorityQueue <String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("John");
        priorityQueue.add("Kate");
        priorityQueue.add("Tom");
        System.out.println("Queue: " + priorityQueue);
        System.out.println("peek: " + priorityQueue.peek());
        //peeking (.peek()) - it will check and return the first in a queue
        System.out.println("queue after peek: " + priorityQueue);
        System.out.println("poll: "+priorityQueue.poll());
        System.out.println("queue after poll: " + priorityQueue);
        //polling will return the first value in a queue and remove it
        ArrayDeque <String> deque = new ArrayDeque<>();
    }
}
