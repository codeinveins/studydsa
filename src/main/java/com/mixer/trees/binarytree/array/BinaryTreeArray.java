package com.mixer.trees.binarytree.array;

public class BinaryTreeArray {
    public String[] arr;
    int lastUsedIndex;

    BinaryTreeArray(int size) {
        this.arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Blank tree using array with size " + size + " has been created.");
    }

    //is binary tree full
    boolean isFull() {
        if(arr.length-1 == lastUsedIndex) {
            return true;
        }
        return false;
    }

    //insert
    void insert(String value) {
        if(!isFull()) {
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println("Successfully inserted "+ value);
        } else {
            System.out.println("Binary tree is full");
        }
    }

    //pre order traversal
    void preOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index*2);
        preOrder(index*2 + 1);
    }

    //in order traversal
    void inOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        inOrder(index*2);
        System.out.print(arr[index] + " ");
        inOrder(index*2 + 1);
    }

    //post order traversal
    void postOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        postOrder(index*2);
        postOrder(index*2 + 1);
        System.out.print(arr[index] + " ");
    }

    //levelOrder traversal
    void levelOrder() {
        for(int i = 1; i<=lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //search
    int search(String value) {
        for(int i = 1; i<=lastUsedIndex; i++) {
            if(arr[i].equals(value)) {
                System.out.println("Value " + value + " found in binary tree at index " + i);
                return i;
            }
        }
        System.out.println("Value " + value + " not found in binary tree");
        return -1;
    }

    void delete(String value) {
        int indexOfNodeToDelete = search(value);
        if(indexOfNodeToDelete == -1) {
            System.out.println(value + " does not exists in the tree");
        } else {
            arr[indexOfNodeToDelete] = arr[lastUsedIndex];
            lastUsedIndex --;
            System.out.println("Node with value "+value+" is successfully deleted");
        }
    }

    void deleteBT() {
        try {
            arr = null;
            lastUsedIndex = 0;
            System.out.println("BT is successfully deleted");
        } catch (Exception e) {
            System.out.println("Error deleting BT = " + e);
        }

    }
}
