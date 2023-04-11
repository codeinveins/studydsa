package com.mixer.trees.avl;

public class Caller {

    public static void main(String[] args) {
        
        AVLTree avlTree = new AVLTree();

        avlTree.insert(30);
        avlTree.insert(25);
        avlTree.insert(35);
        avlTree.insert(20);
        avlTree.insert(15);
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(50);
        avlTree.insert(60);
        avlTree.insert(70);
        avlTree.insert(65);

        System.out.println();
        System.out.print("PreOrder   -> ");
        avlTree.preOrder(avlTree.root);
        System.out.println();
        System.out.print("InOrder    -> ");
        avlTree.inOrder(avlTree.root);
        System.out.println();
        System.out.print("PostOrder  -> ");
        avlTree.postOrder(avlTree.root);
        System.out.println();
        System.out.print("LevelOrder -> ");
        avlTree.levelOrder();
        System.out.println();
        System.out.println();

        avlTree.search(avlTree.root, 10);
        avlTree.search(avlTree.root, 100);

        System.out.println();
        //avlTree.deleteNode(avlTree.root, 70);
        avlTree.levelOrder();

        System.out.println();
        System.out.println();
        System.out.println("Deleting BST");
        //avlTree.deleteBST();
        avlTree.levelOrder();
    }
}
