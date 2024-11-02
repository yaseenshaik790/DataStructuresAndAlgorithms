package org.example.binarytree;

public class TraversalBinaryTree {

    public void traversal(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.val +" Pre ");
        traversal(node.left);
        System.out.println(node.val +" In ");
        traversal(node.right);
        System.out.println(node.val +" Post ");
    }
}
