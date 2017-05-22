package com.fireant.Misc;

import java.util.HashMap;

/**
 * Created by pskumar on 5/19/17.
 */
public class LRUCache {
    HashMap<Integer, LRUNode> lruMap;
    LRUNode head;
    LRUNode end;
    int capacity;

    public static void main(String args[]) {
        LRUCache l = new LRUCache(new HashMap<Integer, LRUNode>(), null, null, 3);
        l.setCache(1);

        l.setCache(2);

        l.setCache(3);

        l.setCache(4);

        l.setCache(1);

        l.getCache(4);

        l.getCache(1);


        l.getCache(3);

        l.getCache(30);

        l.setCache(4);

        LRUNode head = l.head;
        while (head != null) {
            System.out.print(head.val + " -----> ");
            head = head.next;
        }
        System.out.println();
        System.out.println("Head : " +  l.head.val);
        System.out.println("End : " +  l.end.val);

    }


    void deleteNode(LRUNode node) {
        this.lruMap.remove(node.val, node);
        if (node.pre == null && node.next == null) {
            this.head = null;
            this.end = null;
        } else if (node.pre == null) {
            LRUNode newHead = node.next;
            newHead.pre = null;
            this.head = newHead;

        } else if(node.next == null) {
            LRUNode newEnd = node.pre;
            newEnd.next = null;
            this.end = newEnd;

        } else {
            LRUNode newPre = node.pre;
            LRUNode newNext = node.next;
            newPre.next = newNext;
            newNext.pre = newPre;
        }
    }

    void setHead(LRUNode node) {
        if(this.head == node) {
            return;
        }
        else if(this.end == node) {
            if(this.end.pre != null) {
                this.end = this.end.pre;
            }
        }
            LRUNode oldHead = this.head;
            this.head = node;
            if(node.pre != null) {
                node.pre.next = node.next;
            }
            this.head.pre = null;
            this.head.next = oldHead;
            if(oldHead != null) {
                oldHead.pre = this.head;
            } else {
                this.end = this.head;
            }

    }

    void getCache(int key) {
        this.setCache(key);
    }

    void setCache(int key) {
        if(this.lruMap.containsKey(key)) {
            LRUNode newNode = this.lruMap.get(key);
            this.setHead(newNode);
        } else {
            LRUNode newNode = new LRUNode(key, null, null);
            this.lruMap.put(key, newNode);
            if (lruMap.size() > this.capacity) {
                this.deleteNode(this.end);
                this.setHead(newNode);
            } else {
                this.setHead(newNode);
            }
        }

    }

    public LRUCache(
            HashMap<Integer, LRUNode> lruMap,
            LRUNode head,
            LRUNode end,
            int capacity
    ) {
        this.lruMap = lruMap;
        this.head = head;
        this.end = end;
        this.capacity = capacity;
    }
}

class LRUNode {
   int val;
   LRUNode pre;
   LRUNode next;
   public LRUNode(int val, LRUNode pre, LRUNode next) {
       this.val = val;
       this.pre = pre;
       this.next = next;
   }
}
