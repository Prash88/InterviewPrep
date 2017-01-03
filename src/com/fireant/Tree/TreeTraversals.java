package com.fireant.Tree;

public class TreeTraversals {

    public static void main(String[] args) {
        // write your code here
        Tree t1 = new Tree(40, null, null);
        Tree t2 = new Tree(20, null, null);
        Tree t3 = new Tree(60, null, null);
        t1.left = t2;
        t1.right = t3;
        Tree t4 = new Tree(10, null, null);
        Tree t5 = new Tree(30, null, null);
        Tree t6 = new Tree(50, null, null);
        Tree t7 = new Tree(70, null, null);
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeTraversals t = new TreeTraversals();
        System.out.println("Inorder : ");
        t.inorder(t1);
        System.out.println();
        System.out.println("Preorder : ");
        t.preorder(t1);
        System.out.println();
        System.out.println("Postorder : ");
        t.postorder(t1);
    }

    public void inorder(Tree t) {
        if(t == null) return;
        inorder(t.left);
        System.out.print(t.value + "   ");
        inorder(t.right);
    }

    public void preorder(Tree t) {
        if(t == null) return;
        System.out.print(t.value + "   ");
        preorder(t.left);
        preorder(t.right);
    }

    public void postorder(Tree t) {
        if(t == null) return;
        postorder(t.left);
        postorder(t.right);
        System.out.print(t.value + "   ");
    }
}
