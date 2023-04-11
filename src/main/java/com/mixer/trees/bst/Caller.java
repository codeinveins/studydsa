package com.mixer.trees.bst;

public class Caller {
    public static void main(String[] a) {
        BST bst = new BST();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);

        System.out.println();
        System.out.print("PreOrder   -> ");
        bst.preOrder(bst.root);
        System.out.println();
        System.out.print("InOrder    -> ");
        bst.inOrder(bst.root);
        System.out.println();
        System.out.print("PostOrder  -> ");
        bst.postOrder(bst.root);
        System.out.println();
        System.out.print("LevelOrder -> ");
        bst.levelOrder();
        System.out.println();
        System.out.println();

        bst.search(bst.root, 10);
        bst.search(bst.root, 100);

        System.out.println();
        bst.deleteNode(bst.root, 70);
        bst.levelOrder();

        System.out.println();
        System.out.println();
        System.out.println("Deleting BST");
        bst.deleteBST();
        bst.levelOrder();
    }
}
