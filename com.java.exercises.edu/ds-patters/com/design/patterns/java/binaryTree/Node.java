package com.design.patterns.java.binaryTree;

public class Node {
	int value;
    Node left;
    Node right;
 
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
