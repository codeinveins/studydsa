package com.mixer.trees.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    BinaryNode root;

    AVLTree() {
        this.root = null;
    } //O(1) / O(1)

    //preOrder O(N) / O(N)
    public void preOrder(BinaryNode node) {
        //System.out.println("Entered");
        if(node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //inOrder O(N) / O(N)
    void inOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    //postOrder O(N) / O(N)
    void postOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    //level order O(N) / O(N)
    void levelOrder() {
        if(root == null) {
            System.out.println("BST is null");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    //search O(logN) / O(logN)
    BinaryNode search(BinaryNode node, int value) {
        if(node == null) {
            System.out.println(value + " not found in AVL.");
            return null;
        } else if(node.value == value) {
            System.out.println(value + " found in AVL");
            return node;
        } else if(value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
    
    //helper functions for insertion
    public int getHeight(BinaryNode node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private int getBalance(BinaryNode node) {
        if(node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    private BinaryNode insertNode(BinaryNode node, int value) {
        if(node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            newNode.height = 1;
            return newNode;
        } else if(value < node.value) {
            node.left = insertNode(node.left, value);
        } else {
            node.right = insertNode(node.right, value);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);
        if(balance > 1 && value < node.left.value) {
            //LL condition
            return rotateRight(node);
        }

        if(balance > 1 && value > node.left.value) {
            //LR condition
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && value > node.right.value) {
            //RR condition
            return rotateLeft(node);
        }

        if(balance < -1 && value < node.right.value) {
            //RL condition
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

    public void insert(int value) {
        root = insertNode(root, value);
    }
}
