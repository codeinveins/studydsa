package com.mixer.problems.linkedlists;

/*
    We have two sorted linked list as input, output should be single linked list in the sorted format

    Solution :
            Approach 1 : Take 2 pointers to iterate over both linked list
                        create a new linked list whose size will be equal to sum of both input lists
                        while iterating over input lists compare the value at temp pointers,
                            whichever is smaller add it to output list and increment the temp pointer
                            of the list whose element is added
                        It is the same approach which we followed while merge operation in merge sort


 */
public class MergeTwoSortedLinkedList {
}
