package org.example.binarytree;

import java.util.Stack;

class Node{
     Integer val;
     Node left;
     Node right;
    public Node(Integer val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
class Pair{
    Node node;
    Integer state;
    public Pair(Node node, Integer state) {
        this.node = node;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", state=" + state +
                '}';
    }
}
public class ConstructBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null};

        Stack<Pair> stack = new Stack<>();
        Pair rootPair = new Pair(new Node(arr[0], null, null), 1);
        stack.push(rootPair);
        int idx = 0;

        while (!stack.isEmpty() && idx < arr.length - 1){

            Pair top = stack.peek();
            if (top.state == 1){
                idx++;
                if (idx < arr.length && arr[idx] != null){
                    top.node.left = new Node(arr[idx], null, null);
                    Pair leftPair = new Pair(top.node.left, 1);
                    stack.push(leftPair);
                }else {
                    top.node.left = null;
                }
                top.state++;
            }else if (idx < arr.length && top.state == 2){
                idx++;
                if (arr[idx] != null){
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rightPair = new Pair(top.node.right, 1);
                    stack.push(rightPair);
                }else {
                    top.node.right = null;
                }
                top.state++;
            }else {
                stack.pop();
            }
        }
        System.out.println(rootPair);
        displayBinaryTree(rootPair.node);
        System.out.println("Binary Tree Size : "+ size(rootPair.node));
        System.out.println("Binary Tree Sum : "+ sum(rootPair.node));
        System.out.println("Binary Max Node : "+ maxNodeValue(rootPair.node));
        System.out.println("Binary Height : "+ height(rootPair.node));

        //Traverse Binary Tree
        TraversalBinaryTree traversalBinaryTree = new TraversalBinaryTree();
        traversalBinaryTree.traversal(rootPair.node);
    }

    public static int size(Node node){
        if (node == null){
            return 0;
        }
        int ls = size(node.left);//1
        int rs = size(node.right);//2
        int ts = ls+ rs + 1;//3
        return ts;
    }

    public static int sum(Node node){
        if (node == null){
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls+ rs + node.val;
        return ts;
    }

    public static int maxNodeValue(Node node){
        if (node == null){
            return Integer.MIN_VALUE;
        }
        int ls = maxNodeValue(node.left);
        int rs = maxNodeValue(node.right);
        int ts = Math.max(node.val, Math.max(ls, rs));
        return ts;
    }

    public static int height(Node node){
        if (node == null){
            return -1;
        }
        int ls = height(node.left);
        int rs = height(node.right);
        int ts = Math.max(ls, rs) + 1;
        return ts;
    }

    public static void displayBinaryTree(Node rootNode){

        String str = "";
        str += rootNode.left == null ? " . " : " "+rootNode.left.val +" ";
        str += " -  "+rootNode.val+" - ";
        str += rootNode.right == null ? " . " : " "+rootNode.right.val +" ";
        System.out.println(str);


        if (rootNode.left != null){
            displayBinaryTree(rootNode.left);
        }
        if (rootNode.right != null){
            displayBinaryTree(rootNode.right);
        }
    }



}
