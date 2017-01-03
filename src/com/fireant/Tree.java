package com.fireant;

/**
 * Created by pskumar on 1/2/17.
 */
public class Tree {
    int value;
    Tree left;
    Tree right;
    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
