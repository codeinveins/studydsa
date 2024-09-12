package com.mixer.problems.linkedlists;

/*
Find the intersection point between two given input linked lists

Solution:
        Approach 1 : Use a hashmap to store first linked list <Node, Integer>,
            then traverse over the second linked list and match it with the nodes present in the hashmap

        Approach 2 : find the size of list 1 (l1) and list 2 (l2)
            move l2-l1 steps if l2 is bigger
            then iterate over both the linked list and match the node(address) not the node value
            If found then it is the answer otherwise there is no common intersection point
 */

public class IntersectionPointOfTwoLinkedList {
}
