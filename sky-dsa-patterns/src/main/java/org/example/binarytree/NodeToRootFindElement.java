package org.example.binarytree;

public class NodeToRootFindElement {

    public boolean findNode(Node node, int data){
        if (node == null){
            return false;
        }
        if (node.val == data){
            return true;
        }
        boolean leftTree = findNode(node.left, data);
        if (leftTree){
            return true;
        }

        boolean rightTree = findNode(node.right, data);
        if (rightTree){
            return true;
        }

        return false;
    }
}
