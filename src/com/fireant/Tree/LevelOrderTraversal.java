package com.fireant.Tree;

import com.fireant.LinkedList.LinkedListNode;

import java.util.*;

/**
 * Created by pskumar on 1/2/17.
 */
public class LevelOrderTraversal {
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
        LevelOrderTraversal t = new LevelOrderTraversal();
        System.out.println("Level order traversal : ");
        Queue<Tree> q = new LinkedList();
        q.add(t1);
        t.levelOrder(q);
    }

    public void levelOrder(Queue<Tree> q) {
        while(!q.isEmpty()) {
            Tree currentNode = q.remove();
            System.out.print(currentNode.value + "   ");
            if (currentNode.left != null) {
                q.add(currentNode.left);
            }
            if (currentNode.right != null) {
                q.add(currentNode.right);
            }
            levelOrder(q);
        }
    }
}
