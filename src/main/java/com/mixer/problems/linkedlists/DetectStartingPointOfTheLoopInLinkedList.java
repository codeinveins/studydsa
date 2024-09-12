package com.mixer.problems.linkedlists;

/*
We need to find the starting point of the loop in the linked list

Solution:
        Approach 1 : Store the visited nodes in the hashmap <Node, Integer>
                    Check while visiting is the current node present in the hashmap.
                    If you find the node already present then it is the starting point of the loop

        Approach 2 : Use tortoise and hare approach(this will make space complexity as O(1))
                    Take two pointers s(slow) and f(fast)
                    Slow will take one step and fast will take two steps
                    if at some point of time s==f then linked list has loop
                    after we find the loop move slow to head position
                    then we will move both pointers by 1 step
                    now starting point will be the place where both s and f intersect now

 */
public class DetectStartingPointOfTheLoopInLinkedList {
}
