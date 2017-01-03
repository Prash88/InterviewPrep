package com.fireant.LinkedList;

/**
 * Created by pskumar on 1/2/17.
 */
public class Length {
    public static void main(String args[]) {
        LinkedList l = new LinkedList();
        LinkedListNode l1 = new LinkedListNode(10);
        LinkedListNode l2 = new LinkedListNode(120);
        LinkedListNode l3 = new LinkedListNode(103);
        LinkedListNode l4 = new LinkedListNode(110);
        LinkedListNode l5 = new LinkedListNode(20);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        l.head = l1;
        Length ln = new Length();
        System.out.println("Length of the list : " + ln.listLength(l.head, 0));
    }

    public int listLength(LinkedListNode head, int l) {
        LinkedListNode currentNode = head;
        if (currentNode != null) {
            l++;
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
            l = listLength(currentNode, l);
        }
        return l;
    }
}
