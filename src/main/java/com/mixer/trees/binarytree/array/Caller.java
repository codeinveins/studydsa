package com.mixer.trees.binarytree.array;

public class Caller {

    public static void main(String[] a) {
        BinaryTreeArray binaryTree = new BinaryTreeArray(9);
        binaryTree.insert("N1");
        binaryTree.insert("N2");
        binaryTree.insert("N3");
        binaryTree.insert("N4");
        binaryTree.insert("N5");
        binaryTree.insert("N6");
        binaryTree.insert("N7");
        binaryTree.insert("N8");
        binaryTree.insert("N9");

        System.out.println();
        System.out.print("Pre Order   ->");
        binaryTree.preOrder(1);
        System.out.println();
        System.out.print("In order    ->");
        binaryTree.inOrder(1);
        System.out.println();
        System.out.print("Post Order  ->");
        binaryTree.postOrder(1);
        System.out.println();
        System.out.print("Level Order ->");
        binaryTree.levelOrder();

        System.out.println();
        System.out.println();
        binaryTree.search("N8");
        System.out.println();
        binaryTree.search("N10");

        System.out.println();
        System.out.println();

        binaryTree.delete("N5");
        binaryTree.levelOrder();

        System.out.println();
        System.out.println();

        binaryTree.delete("N10");
        binaryTree.levelOrder();

        System.out.println();
        System.out.println();
        binaryTree.deleteBT();
    }
}
