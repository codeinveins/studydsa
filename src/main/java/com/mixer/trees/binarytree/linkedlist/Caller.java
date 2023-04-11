package com.mixer.trees.binarytree.linkedlist;

public class Caller {
    public static void main(String[] args) {

        /*
        BinaryNode N1 = new BinaryNode();
        N1.data = "N1";
        BinaryNode N2 = new BinaryNode();
        N2.data = "N2";
        BinaryNode N3 = new BinaryNode();
        N3.data = "N3";
        BinaryNode N4 = new BinaryNode();
        N4.data = "N4";
        BinaryNode N5 = new BinaryNode();
        N5.data = "N5";
        BinaryNode N6 = new BinaryNode();
        N6.data = "N6";
        BinaryNode N7 = new BinaryNode();
        N7.data = "N7";
        BinaryNode N8 = new BinaryNode();
        N8.data = "N8";
        BinaryNode N9 = new BinaryNode();
        N9.data = "N9";

        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N3.left = N6;
        N3.right = N7;
        N4.left = N8;
        N4.right = N9;
        */

        BinaryTreeLL binaryTree = new BinaryTreeLL();
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

        /*
        binaryTree.preOrder(N1);
        System.out.println();
        binaryTree.inOrder(N1);
        System.out.println();
        binaryTree.postOrder(N1);
        System.out.println();
        binaryTree.levelOrder(N1);
        System.out.println();
         */

        System.out.print("PreOrder   -> ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.print("InOrder    -> ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.print("PostOrder  -> ");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        System.out.print("LevelOrder -> ");
        binaryTree.levelOrder(binaryTree.root);

        System.out.println();
        System.out.println();
        binaryTree.search("N7");
        System.out.println();
        binaryTree.search("N10");

        System.out.println();
        System.out.println();

        BinaryNode deepestNode = binaryTree.getDeepestNode();
        System.out.print("Deepest node is ->" + deepestNode.data);
        System.out.println();
        System.out.print("Deleting deepest node");
        binaryTree.deleteDeepestNode();
        System.out.println();
        BinaryNode deepestNodePostDelete = binaryTree.getDeepestNode();
        System.out.print("Deepest node post deleting prev deepest node is ->" + deepestNodePostDelete.data);

        System.out.println();
        System.out.print("Tree is -> ");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();
        System.out.println("Deleting N3 from tree");
        binaryTree.deleteNode("N3");
        BinaryNode deepestNodePostDelete2 = binaryTree.getDeepestNode();
        System.out.print("Deepest node post deleting N3 is ->" + deepestNodePostDelete2.data);
        System.out.println();
        System.out.print("Tree is -> ");
        binaryTree.levelOrder(binaryTree.root);


        System.out.println();
        System.out.println();

        System.out.print("Tree is -> ");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();
        System.out.println("Deleting N10 from tree");
        binaryTree.deleteNode("N10");

        System.out.println();
        System.out.println();
        binaryTree.deleteBinaryTree();
        System.out.print("Tree is -> ");
        binaryTree.levelOrder(binaryTree.root);


    }
}
