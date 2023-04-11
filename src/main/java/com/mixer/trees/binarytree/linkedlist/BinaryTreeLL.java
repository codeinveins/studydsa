package com.mixer.trees.binarytree.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    public BinaryNode root;

    BinaryTreeLL() {
        this.root = null;
    }

    //traversal

    //preOrder
    void preOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //inOrder
    void inOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //postOrder
    void postOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    //levelOrder
    void levelOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.data + " ");
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    //search
    void search(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if(presentNode.data.equals(value)) {
                System.out.print(value + " found in tree");
                return;
            }
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.print(value + " not found in tree");
    }

    //insert
    void insert(String value) {

        BinaryNode node = new BinaryNode();
        node.data = value;
        if(root == null) {
            root = node;
            System.out.println("Successfully inserted "+value+ " as root node");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if(presentNode.left == null) {
                presentNode.left = node;
                System.out.println("Successfully inserted " +value+ " as left child to " + presentNode.data);
                break;
            } else if(presentNode.right == null) {
                presentNode.right = node;
                System.out.println("Successfully inserted " +value+ " as right child to " + presentNode.data);
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    //get deepest node
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;

        while(!queue.isEmpty()) {
            presentNode = queue.remove();
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }

        return presentNode;
    }

    //delete deepest node
    void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;

        while(!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();

            if(presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if(presentNode.right == null) {
                presentNode.left = null;
                return;
            }

            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    //delete given node
    void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if(presentNode.data.equals(value)) {
                presentNode.data = getDeepestNode().data;
                deleteDeepestNode();
                System.out.println("Node with value " + value + " is deleted.");
                return;
            }
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }

        System.out.println("Node with value "+value+" does not exist in tree.");
    }

    //delete binary tree
    void deleteBinaryTree() {
        root = null;
        System.out.println("Tree is successfully deleted");
    }
}
